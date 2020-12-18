package accessingDataJPA.validator;

import accessingDataJPA.model.Client;
import accessingDataJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (client.getLogin().length() < 1 || client.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.userForm.username");
        }
        if (userService.getClientByLogin(client.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mdp", "NotEmpty");
        if (client.getMdp().length() < 2 || client.getMdp().length() > 32) {
            errors.rejectValue("mdp", "Size.userForm.password");
        }

        if (!client.getMdp().equals(client.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}