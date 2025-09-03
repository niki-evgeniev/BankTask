package nevg.banktask.Service;

import jakarta.validation.Valid;
import nevg.banktask.DTO.RegisterUserDTO;

public interface UserService {

    boolean registerUser(@Valid RegisterUserDTO registerUserDTO);
}
