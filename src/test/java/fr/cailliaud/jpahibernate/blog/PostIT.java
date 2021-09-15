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
    postService.ajouterComment(post.getId(), """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam tortor magna, eleifend porta semper a, egestas in mauris. Cras varius, magna mattis sagittis maximus, dolor eros scelerisque lorem, in eleifend mi risus in nunc. Donec nec tincidunt tortor, id elementum ante. Aenean tempor lobortis bibendum. Morbi ornare sollicitudin imperdiet. Aliquam vitae gravida massa, a rutrum sem. Vestibulum tincidunt felis at enim facilisis, ac aliquet nisl sollicitudin. Curabitur quis aliquet magna, at porttitor massa. Quisque ipsum sem, sollicitudin et lectus eu, luctus fermentum leo. Sed mattis purus orci, rutrum mollis dui feugiat sit amet. Etiam nec ex risus.
            
            Proin eleifend maximus nisi, in semper lectus suscipit eu. In accumsan, neque sodales pretium posuere, lectus lectus rhoncus ligula, id scelerisque odio mi non nibh. Fusce dignissim tortor sed justo finibus feugiat. Maecenas ligula erat, pretium sed mauris quis, aliquet aliquet justo. Nulla gravida, felis convallis vehicula feugiat, ligula lacus congue erat, eu commodo purus erat eget ante. Pellentesque posuere faucibus scelerisque. Integer nisi urna, viverra eget lobortis eu, porttitor in lacus. Aliquam sagittis urna est. Aenean leo nisl, auctor sed pharetra id, pellentesque eget ligula. Phasellus et interdum urna. Suspendisse ullamcorper ante a est aliquam, vitae condimentum velit venenatis. Sed laoreet urna id ipsum fringilla ullamcorper. Aliquam dictum risus at justo varius, et vehicula sem feugiat. Sed convallis ac lorem vel suscipit. Aenean lectus lorem, luctus vitae consectetur sit amet, laoreet non lectus.
            
            Mauris mi ante, fringilla tempor pretium nec, vulputate et eros. Nunc eu libero vel purus viverra dignissim non et orci. Nunc tincidunt congue mollis. Fusce tincidunt mattis velit vel feugiat. Suspendisse felis est, volutpat at scelerisque quis, rhoncus id est. Vivamus libero sapien, finibus in dignissim vel, ullamcorper vel odio. Donec gravida lorem in augue tempus, sed consectetur augue rutrum. Nunc id enim mauris. Sed id pretium leo. Praesent imperdiet efficitur blandit. Praesent pretium orci ut auctor faucibus. Maecenas vel nulla pretium, posuere nisi eget, vestibulum urna. Phasellus euismod posuere ante, ac tincidunt odio consequat sit amet. Mauris enim ligula, ultrices malesuada ultrices et, elementum pellentesque erat. Cras non odio eros.
            
            Nulla sed sollicitudin elit. Vestibulum imperdiet sapien elementum, consectetur tortor vitae, vulputate neque. Sed sit amet nibh consectetur, bibendum metus sed, viverra lacus. Fusce pharetra ac nulla nec laoreet. Curabitur non placerat purus. Sed vel ornare ante, non blandit augue. Aenean luctus ut metus sed aliquam. Duis arcu lacus, dictum id commodo sit amet, finibus eget sem. Curabitur sagittis quis nisi non fringilla. Aliquam diam dui, sagittis sit amet metus pharetra, eleifend mollis est. Donec pretium pellentesque mauris, vitae viverra urna volutpat eget. Morbi semper nisl ex, at lobortis metus eleifend eget. Fusce vitae leo ante. Suspendisse ligula dui, rutrum at neque id, rutrum finibus mauris. Suspendisse pharetra leo vel lacus imperdiet, sodales viverra ante finibus. Mauris luctus egestas est, in auctor felis feugiat vitae.
            
            Nunc augue dui, fringilla eu arcu eu, condimentum condimentum quam. Maecenas malesuada felis felis, ornare ultrices ante congue sit amet. Nunc egestas eu massa vel imperdiet. Suspendisse potenti. Integer odio velit, dictum non lectus at, pharetra tincidunt neque. Duis quam mauris, vestibulum at velit ac, aliquet hendrerit felis. Mauris non eros turpis. Aliquam maximus purus vitae nulla imperdiet, ac feugiat metus aliquet. Donec fringilla nunc sit amet dolor dignissim, eget dignissim nunc cursus. In accumsan lorem sit amet turpis bibendum volutpat. Vivamus ultricies tristique leo, vitae aliquet turpis finibus ac. Sed in leo turpis.
            """);
    // Then
    Post postRetrieved = postService.getPost(post.getId());
  }
}
