package nevg.banktask.init;


import nevg.banktask.Service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddToDataBase implements CommandLineRunner {

    private final UserRoleService userRoleService;

    public AddToDataBase(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("enter in AddToDataBase");
        userRoleService.addRolesIfNotExist();
    }
}
