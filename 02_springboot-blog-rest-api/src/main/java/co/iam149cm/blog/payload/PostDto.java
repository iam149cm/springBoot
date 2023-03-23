package co.iam149cm.blog.payload;

import lombok.Data;

// 데이터를 return 시에는 entity 를 직접 리턴하는 것이 아니라
// dto 를 payload 로써 리턴한다
@Data
public class PostDto {

    private long id;
    private String title;
    private String description;
    private String content;
}
