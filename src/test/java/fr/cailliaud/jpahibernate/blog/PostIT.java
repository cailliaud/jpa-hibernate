package fr.cailliaud.jpahibernate.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostIT {

  @Autowired PostService postService;

  @Test
  void test_post() {
    // Given
    String title = "Hello, first post";
    String postCode = "NEWS_H2";
    // When
    Post post = postService.createPost(title, postCode);
    // Then
    Post postRetrieved = postService.getPost(post.getId());
  }
}
