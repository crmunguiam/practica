package api.v1;

import api.v1.entity.User;
import api.v1.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnListUser(){
        User user01 = User.builder().name("Luis").id(1L).
                lastName("Lopez").surname("Lopez").rfc("Llopez").worshift("1").gender("1").phone("55216488").pin("888")
                .birthdate(new Date()).build();
        userRepository.save(user01);

        List<User> fouds= userRepository.findByName(user01.getName());

        Assertions.assertThat(fouds.size()).isEqualTo(1);
    }

}
