package fr.cailliaud.jpahibernate.blog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferentialPostRepository extends JpaRepository<ReferentialPost, String> {

  Optional<ReferentialPost> findByCode(String code);
}
