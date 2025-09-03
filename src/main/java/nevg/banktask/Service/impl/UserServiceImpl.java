package nevg.banktask.Service.impl;

import nevg.banktask.DTO.RegisterUserDTO;
import nevg.banktask.Entity.User;
import nevg.banktask.Repository.UserRepository;
import nevg.banktask.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(RegisterUserDTO registerUserDTO) {
        String email = registerUserDTO.getEmail();
        String password = registerUserDTO.getPassword();

        Optional<User> findByEmail = userRepository.findByEmail(email);
        if (findByEmail.isEmpty()) {
            if (!password.isEmpty()) {
                User user = new User();
                user.setEmail(email);
                String encodePassword = passwordEncoder.encode(password);
                user.setPassword(encodePassword);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }
}
