package nevg.banktask.Controller;

import jakarta.validation.Valid;
import nevg.banktask.DTO.RegisterUserDTO;
import nevg.banktask.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/account/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    ResponseEntity<?> getRegisterInfo(@Valid @RequestBody RegisterUserDTO registerUserDTO) {

        boolean isRegisterNewUSer = userService.registerUser(registerUserDTO);

        return ResponseEntity
                .created(URI.create("/api/users/"))
                .build();
    }
}
