package co.iam149cm.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

// 데이터를 return 시에는 entity 를 직접 리턴하는 것이 아니라
// dto 를 payload 로써 리턴한다
@Data
@Schema(description = "PostDto Model Information")
public class PostDto {

    private long id;

    // title should not be null or empty.
    // title should have at least 2 characters
    @NotEmpty
    @Size(min=2, message="Post title should have at least 2 characters")
    @Schema(description = "Blog Post title")
    private String title;

    @NotEmpty
    @Size(min=10, message="Post description should have at least 10 characters")
    @Schema(description = "Blog Post description")
    private String description;

    @NotEmpty
    @Schema(description = "Blog Post Content")
    private String content;
    private Set<CommentDto> comments;

    @Schema(description = "Post Category")
    private long categoryId;
}
