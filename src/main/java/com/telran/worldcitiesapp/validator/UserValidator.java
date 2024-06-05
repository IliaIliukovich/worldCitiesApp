package com.telran.worldcitiesapp.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private static final String LOGIN_PASSWORD_PATTERN = "[A-Za-z0-9_-]+";
    private static final String NAME_LENGTH_LIMIT = "Name length should be no more than 45 symbols";
    private static final String SYMBOLS_LIMIT = "Incorrect symbols used";
    private static final String PASSWORD_LENGTH = "Password length should be no less than 8 symbols";
    private static final String CHECK_LOGIN_INPUT = "Check login input";
    private static final String CHECK_PASSWORD_INPUT = "Check password input";
    private static final String PASSWORD_NOT_CONFIRM_PASSWORD = "Password does not match the confirmPassword field";

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getUsername().length() > 20) {
            errors.rejectValue("username", NAME_LENGTH_LIMIT, NAME_LENGTH_LIMIT);
        }
        if (!user.getUsername().matches(LOGIN_PASSWORD_PATTERN)){
            errors.rejectValue("username", SYMBOLS_LIMIT, SYMBOLS_LIMIT);
        }
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", PASSWORD_LENGTH, PASSWORD_LENGTH);
        }
        if (!user.getPassword().matches(LOGIN_PASSWORD_PATTERN)){
            errors.rejectValue("password", SYMBOLS_LIMIT, SYMBOLS_LIMIT);
        }
    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) {
        if (login.length() > 20 || !login.matches(LOGIN_PASSWORD_PATTERN)) {
            throw new IllegalArgumentException(CHECK_LOGIN_INPUT);
        }

        if (password.length() < 8 || !password.matches(LOGIN_PASSWORD_PATTERN)) {
            throw new IllegalArgumentException(CHECK_PASSWORD_INPUT);
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException(PASSWORD_NOT_CONFIRM_PASSWORD);
        }
    }
}
