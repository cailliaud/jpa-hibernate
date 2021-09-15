package fr.cailliaud.jpahibernate;

import fr.cailliaud.jpahibernate.user.User;
import fr.cailliaud.jpahibernate.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaHibernateApplicationTests {

  @Autowired private UserService userService;

  @Test
  void contextLoads() {

    User user = userService.createUser();
    userService.modifyWithExplicitSaveCalled(user.getId(), "BernardSaveCalled");
    userService.modifyWithoutExplicitSaveCalled(user.getId(), "BernardSaveNotCalled");
    userService.deleteUserWithoutEntity(user.getId());

    user = userService.createUser();
    userService.deleteUserWithEntity(user.getId());

    user = userService.createUser();
    userService.deleteUserWithEntityInTransaction(user.getId());
  }
}
