package co.iam149cm.blog.service;

import co.iam149cm.blog.entity.Comment;
import co.iam149cm.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentByPostId(long postId);
    CommentDto getCommentById(long postId, long commentId);
    CommentDto updateComment(long postId, long commentId, CommentDto commentRequest);
    void deleteComment(long postId, long commentId);
}
