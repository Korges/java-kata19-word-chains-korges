package com.korges.krk.helper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class UserOptionTest {

    private static UserOption userOption;

    @BeforeAll
    static void createUserOption() {
        userOption = UserOption.START;
    }

    @Test
    void recognizeUserOption() {

        assertEquals(UserOption.EXIT, userOption.recognizeUserOption("EXIT"));
    }
}