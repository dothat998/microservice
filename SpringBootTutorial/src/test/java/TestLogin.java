import com.spring.dto.UserDto;
import com.spring.service.UserService;
import com.spring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class TestLogin {

    @Test
    public void addUser(){
        UserService userService = new UserServiceImpl();
        Page<UserDto> listUser = userService.getListUser(0,1);
        assertThat(listUser).isNotNull();

    }
}
