package co.iam149cm.blog.repository;

import co.iam149cm.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository - 생략 가능하다. 이유 : SimpleJpaRepository 에서 이미 @Repository 가 있기 때문

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);

}
