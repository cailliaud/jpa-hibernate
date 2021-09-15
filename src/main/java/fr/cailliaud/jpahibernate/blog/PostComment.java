package fr.cailliaud.jpahibernate.blog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "post_comment")
@Entity
@Getter
@Setter
public class PostComment {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post_comment_generator")
  @SequenceGenerator(
      name = "seq_post_comment_generator",
      sequenceName = "seq_post_comment",
      allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "post_ID")
  private Post post;
}
