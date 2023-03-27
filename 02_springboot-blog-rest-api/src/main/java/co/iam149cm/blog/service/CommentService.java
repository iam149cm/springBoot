package co.iam149cm.blog.service;

import co.iam149cm.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
