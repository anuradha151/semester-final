package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.model.User;
import lk.anuradha.car.repository.UserRepository;
import lk.anuradha.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean canAuthenticate(String username, String password) {
        boolean exists = userRepository.existsById(username);

        if (!exists) {
            return false;
        }

        User user = userRepository.findById(username).get();

        return user.getPassword().equals(password);
    }
}
