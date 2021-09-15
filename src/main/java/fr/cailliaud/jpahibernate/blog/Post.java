package fr.cailliaud.jpahibernate.blog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "post")
@Entity
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post_generator")
  @SequenceGenerator(name = "seq_post_generator", sequenceName = "seq_post", allocationSize = 1)
  private Long id;

  private String title;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  private ReferentialPost referentialPost;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PostComment> comments = new ArrayList<>();

  public Post addComment(PostComment comment) {
    comment.setPost(this);
    comments.add(comment);
    return this;
  }
}
