package co.iam149cm.blog.service;


import co.iam149cm.blog.entity.Post;
import co.iam149cm.blog.payload.PostDto;
import co.iam149cm.blog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);

}
