package com.teamproject.bet4life.annotations;


import com.teamproject.bet4life.RegistrationModel.RegistrationModel;
import com.teamproject.bet4life.bindingModels.UserBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordMatchingValidator implements ConstraintValidator<IsPasswordMatching, Object> {
    @Override
    public void initialize(IsPasswordMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext context) {
        if (userClass instanceof UserBindingModel) {
            return ((UserBindingModel) userClass)
                    .getPassword()
                    .equals(((UserBindingModel) userClass)
                            .getConfirmPassword());
        }
        return false;
    }
}

