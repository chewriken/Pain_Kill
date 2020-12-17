package accessingDataJPA.validator;

import accessingDataJPA.model.Client;
import accessingDataJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ModificationValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        if (userService.getClientByLogin(client.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.username");
        }

        if (!client.getMdp().equals(client.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}