package com.telran.worldcitiesapp.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private Errors errors;
    private UserValidator userValidator;
    private static final String LOGIN_PASSWORD_PATTERN = "[A-Za-z0-9-]+";
    private static final String NAME_LENGTH_LIMIT = "Name length should be no more than 45 symbols";
    private static final String SYMBOLS_LIMIT = "Incorrect symbols used";
    private static final String PASSWORD_LENGTH = "Password length should be no less than 8 symbols";
    private static final String CHECK_LOGIN_INPUT = "Check login input";
    private static final String CHECK_PASSWORD_INPUT = "Check password input";
    private static final String PASSWORD_NOT_CONFIRM_PASSWORD = "Password does not match the confirmPassword field";

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    void validate() {
        errors = Mockito.mock(Errors.class);
        User user = new User();
        assertThrows(NullPointerException.class, () -> userValidator.validate(user, errors));

        user.setUsername("WrongFirstName1_WrongLastName2");
        user.setPassword("A1_B2_C3_D4");
        userValidator.validate(user, errors);
        Mockito.verify(errors).rejectValue("username", NAME_LENGTH_LIMIT, NAME_LENGTH_LIMIT);

        user.setUsername("#");
        user.setPassword("A1_B2_C3_D4");
        userValidator.validate(user, errors);
        Mockito.verify(errors).rejectValue("username", SYMBOLS_LIMIT, SYMBOLS_LIMIT);

        user.setUsername("Name1_LastName2");
        user.setPassword("A1_B2");
        userValidator.validate(user, errors);
        Mockito.verify(errors).rejectValue("password", PASSWORD_LENGTH, PASSWORD_LENGTH);

        user.setUsername("Name1_LastName2");
        user.setPassword("##################");
        userValidator.validate(user, errors);
        Mockito.verify(errors).rejectValue("password", SYMBOLS_LIMIT, SYMBOLS_LIMIT);

    }

    @Test
    void checkLoginAndPassword() {
        IllegalArgumentException illegalArgumentException;

        String login = "Name1_LastName2";
        String wrongPatternLogin = "#";
        String wrongLengthLogin = "WrongFirstName1_WrongLastName2";

        String password = "A1_B2_C3_D4";
        String wrongPatternPassword = "#";
        String wrongLengthPassword = "A1_B2";

        String confirmPassword = "A1_B2_C3_D4";
        String wrongConfirmPassword = "A1_B2_C3";

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userValidator.checkLoginAndPassword(wrongLengthLogin, password, confirmPassword));
        assertEquals(CHECK_LOGIN_INPUT, illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userValidator.checkLoginAndPassword(wrongPatternLogin, password, confirmPassword));
        assertEquals(CHECK_LOGIN_INPUT, illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userValidator.checkLoginAndPassword(login, wrongLengthPassword, confirmPassword));
        assertEquals(CHECK_PASSWORD_INPUT, illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userValidator.checkLoginAndPassword(login, wrongPatternPassword, confirmPassword));
        assertEquals(CHECK_PASSWORD_INPUT, illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userValidator.checkLoginAndPassword(login, password, wrongConfirmPassword));
        assertEquals(PASSWORD_NOT_CONFIRM_PASSWORD, illegalArgumentException.getMessage());
    }
}