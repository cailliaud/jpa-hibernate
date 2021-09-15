package fr.cailliaud.jpahibernate.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public User createUser() {
    log.info("### BEGIN USER CREATION ###");
    User user = new User();
    user.setUsername("Bernard");
    user.setEmail("bernard@gmail.com");
    userRepository.save(user);
    log.info("### END USER INIT ###");
    return user;
  }

  @Transactional
  public void modifyWithoutExplicitSaveCalled(long id, String newUsername) {
    log.info("### MODIFY USER WITHOUT EXPLICITE .SAVE() CALLED ###");
    User user = userRepository.findById(id).orElseThrow();
    user.setUsername(newUsername);
    log.info("### END MODIFY USER WITHOUT EXPLICITE .SAVE() CALLED ###");
  }

  @Transactional
  public void modifyWithExplicitSaveCalled(long id, String newUsername) {
    log.info("### MODIFY USER WITH EXPLICITE .SAVE() CALLED ###");
    User user = userRepository.findById(id).orElseThrow();
    user.setUsername(newUsername);
    userRepository.save(user);
    log.info("### END MODIFY USER WITH EXPLICITE .SAVE() CALLED ###");
  }

  public void deleteUserWithoutEntity(long id) {
    log.info("### DELETE USER WITHOUT ENTITY ###");
    userRepository.deleteById(id);
    log.info("### END USER DELETION WITHOUT ENTITY ###");
  }

  @Transactional
  public void deleteUserWithEntity(long id) {
    log.info("### DELETE USER WITH ENTITY ###");
    User user = userRepository.findById(id).orElseThrow();
    userRepository.delete(user);
    log.info("### END USER DELETION WITH ENTITY ###");
  }

  @Transactional
  public void deleteUserWithEntityInTransaction(long id) {
    log.info("### DELETE USER WITH ENTITY IN TRANSACTION ###");
    User user = userRepository.findById(id).orElseThrow();
    userRepository.delete(user);
    log.info("### END USER DELETION WITH ENTITY IN TRANSACTION ###");
  }
}
