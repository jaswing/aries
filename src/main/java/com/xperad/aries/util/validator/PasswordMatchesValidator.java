package com.xperad.aries.util.validator;

import com.xperad.aries.persistence.model.User;
import com.xperad.aries.util.annotation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/24
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user = (User) value;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
