package co.iam149cm.blog.repository;

import co.iam149cm.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> { // post 의 id 가 long type이기 때문

    List<Post> findByCategoryId(long categoryId);

}
