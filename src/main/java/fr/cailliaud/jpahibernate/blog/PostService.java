package fr.cailliaud.jpahibernate.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final ReferentialPostRepository referentialPostRepository;

  @Transactional
  public Post createPost(String title, String postCode) {
    Post post = new Post();
    post.setTitle(title);
    post.setReferentialPost(referentialPostRepository.findByCode(postCode).orElseThrow());
    return postRepository.save(post);
  }

  @Transactional(readOnly = true)
  public Post getPost(Long id) {
    return postRepository.findById(id).orElseThrow();
  }

  @Transactional
  public void ajouterComment(Long postId, String content) {
    Post post = postRepository.findById(postId).orElseThrow();
    PostComment postComment = new PostComment();
    postComment.setText(content);
    post.addComment(postComment);
  }
}
