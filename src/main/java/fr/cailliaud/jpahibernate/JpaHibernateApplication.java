package fr.cailliaud.jpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JpaHibernateApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaHibernateApplication.class);
  }
}
