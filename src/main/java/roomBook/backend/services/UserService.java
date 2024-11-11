package roomBook.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roomBook.backend.entities.User;
import roomBook.backend.repositories.UserRepository;
import roomBook.backend.reqmodels.ReqUser;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean save(ReqUser reqUser) {
        User user = User.mapUser(reqUser);
        userRepository.save(user);
        return true;
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
