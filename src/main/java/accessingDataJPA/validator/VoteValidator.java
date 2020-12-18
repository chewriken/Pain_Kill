package accessingDataJPA.validator;

import accessingDataJPA.data.SondageDAO;
import accessingDataJPA.model.Sondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VoteValidator implements Validator {
    @Autowired
    SondageDAO sondageDAO;

    @Override
    public boolean supports(Class<?> aClass) {return Sondage.class.equals(aClass);}

    @Override
    public void validate(Object o, Errors errors) {
        Sondage sondage = (Sondage) o;
        if (sondageDAO.getVoteSondageByName(sondage.getName()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.username");
        }
    }
}
