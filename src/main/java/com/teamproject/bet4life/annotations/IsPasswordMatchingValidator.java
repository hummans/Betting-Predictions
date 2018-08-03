package com.teamproject.bet4life.annotations;

import com.teamproject.bet4life.entities.User;
import com.teamproject.bet4life.model.RegistrationModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordMatchingValidator implements ConstraintValidator<IsPasswordMatching, Object> {
    @Override
    public void initialize(IsPasswordMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext context) {
        if (userClass instanceof RegistrationModel){
            return ((RegistrationModel) userClass)
                    .getPassword()
                    .equals(((RegistrationModel) userClass)
                            .getConfirmedPassword());
        }
        return false;
    }
}
