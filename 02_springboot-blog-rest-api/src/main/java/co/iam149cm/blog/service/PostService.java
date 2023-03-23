package co.iam149cm.blog.service;


import co.iam149cm.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
