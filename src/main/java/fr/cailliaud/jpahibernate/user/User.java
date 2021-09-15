package fr.cailliaud.jpahibernate.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(
    name = "user",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "UK_user_mail",
          columnNames = {"email"})
    })
@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
  @SequenceGenerator(
      name = "user_sequence_generator",
      sequenceName = "user_sequence",
      allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false, length = 100)
  private String username;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;
}
