package nevg.banktask.Service.impl;

import nevg.banktask.Entity.Enum.RoleType;
import nevg.banktask.Entity.UserRole;
import nevg.banktask.Repository.UserRoleRepository;
import nevg.banktask.Service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void addRolesIfNotExist() {
        if (userRoleRepository.count() == 0) {
            RoleType[] values = RoleType.values();
            for (RoleType value : values) {
                UserRole userRole = new UserRole();
                userRole.setRoleType(value);
                System.out.println(userRole);
                userRoleRepository.save(userRole);
            }
        }
    }
}
