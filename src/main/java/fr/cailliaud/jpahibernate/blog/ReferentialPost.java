package fr.cailliaud.jpahibernate.blog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "referential_post")
@Entity
@Getter
@Setter
public class ReferentialPost {

  @Id private String code;

  @Column(nullable = false)
  private String category;

  private String subCategory;
}
