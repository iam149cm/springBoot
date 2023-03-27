package co.iam149cm.blog.controller;

import co.iam149cm.blog.entity.Comment;
import co.iam149cm.blog.payload.CommentDto;
import co.iam149cm.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId,
                                                    @RequestBody CommentDto commentDto) {

        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable("postId") long postId) {
        return commentService.getCommentByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable long postId,
                                                     @PathVariable("id") long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long postId,
                                                    @PathVariable("id") long commentId,
                                                    @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long postId,
                                                @PathVariable("id") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);

    }
}
