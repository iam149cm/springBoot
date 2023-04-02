package co.iam149cm.blog.controller;

import co.iam149cm.blog.payload.PostDto;
import co.iam149cm.blog.payload.PostDtoV2;
import co.iam149cm.blog.payload.PostResponse;
import co.iam149cm.blog.service.PostService;
import co.iam149cm.blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "CRUD REST APIs for Post Resource")
public class PostController {

    private PostService postService; // use interface to make loose coupling

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // only ADMIN can create post
    @SecurityRequirement(name = "Bear Authentication") // SecurityConfig.java 에서 설정한 스키마 이름
    @Operation(summary = "Create Post REST API", description = "Create Post REST API is used to save post into database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    @Operation(summary = "Get All Post REST API", description = "Fetch all Post from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // get post by Id
//    @GetMapping(value = "/{id}", params = "version=1") // versioning through query params
//    @GetMapping(value = "/{id}", headers = "X-API-VERSION=1") // versioning through the custom headers
    @GetMapping(value = "/{id}", produces = "application/vnd.iam149cm.v1+json") // versioning through the content negotiation
    @Operation(summary = "Get Post by id REST API", description = "Get single Post from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // get post by Id
//    @GetMapping(value = "/{id}", params = "version=2") // versioning through query params
//    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2") // versioning through the custom headers
    @GetMapping(value = "/{id}", produces = "application/vnd.iam149cm.v2+json") // versioning through the content negotiation
    @Operation(summary = "Get Post by id REST API", description = "Get single Post from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    public ResponseEntity<PostDtoV2> getPostByIdV2(@PathVariable(name = "id") long id){
        PostDto postDto = postService.getPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());
        postDtoV2.setComments(postDto.getComments());

        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring Boot");
        tags.add("AWS");
        postDtoV2.setTags(tags);

        return ResponseEntity.ok(postDtoV2);
    }

    // update post by Id
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bear Authentication")
    @Operation(summary = "Update Post REST API", description = "Update a particular Post in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable(name="id") long id) {
        PostDto postResponse =  postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post by Id
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bear Authentication")
    @Operation(summary = "Delete Post REST API", description = "Delete a particular Post in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

    // Build Get Posts by Category REST API
    // http://localhost:8080/api/posts/category/3
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("id") long categoryId) {
        List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }
}
