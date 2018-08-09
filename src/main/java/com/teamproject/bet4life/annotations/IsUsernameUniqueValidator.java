package com.teamproject.bet4life.annotations;

import com.teamproject.bet4life.bindingModels.UserBindingModel;
import com.teamproject.bet4life.services.UserServiceImpl;
import com.teamproject.bet4life.services.base.FieldValueExists;
import com.teamproject.bet4life.services.base.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsUsernameUniqueValidator implements ConstraintValidator<IsUsernameUnique, Object> {
    @Autowired
    private ApplicationContext applicationContext;

    private FieldValueExists service;
    private String fieldName;

    @Override
    public void initialize(IsUsernameUnique constraintAnnotation) {
        Class<? extends FieldValueExists> clazz = constraintAnnotation.service();
        this.fieldName = constraintAnnotation.fieldName();
        String serviceQualifier = constraintAnnotation.serviceQualifier();

        if (!serviceQualifier.equals("")) {
            this.service = this.applicationContext.getBean(serviceQualifier, clazz);
        } else {
            this.service = this.applicationContext.getBean(clazz);
        }
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        return !this.service.fieldValueExists(o, this.fieldName);
    }

}
