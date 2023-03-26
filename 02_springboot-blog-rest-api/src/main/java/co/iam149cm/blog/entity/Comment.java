package co.iam149cm.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // make JPA entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    // FetchType.LAZY tells Hibernate to only Fetch the related entities
    // from the database when you use the relationship
    @JoinColumn(name = "post_id", nullable = false) // foreign key
    private Post post;


}
