package co.iam149cm.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

// 데이터를 return 시에는 entity 를 직접 리턴하는 것이 아니라
// dto 를 payload 로써 리턴한다
@Data
public class PostDto {

    private long id;

    // title should not be null or empty.
    // title should have at least 2 characters
    @NotEmpty
    @Size(min=2, message="Post title should have at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min=10, message="Post description should have at least 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
