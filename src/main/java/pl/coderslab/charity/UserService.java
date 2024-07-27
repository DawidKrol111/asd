package pl.coderslab.charity;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entities.User;
@Service
public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

}
