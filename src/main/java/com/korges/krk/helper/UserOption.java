package com.korges.krk.helper;

public enum UserOption {

    START("start"),
    CHECK("check"),
    EXIT("exit");

    public String userOption;

    UserOption(String userOption) {
        this.userOption = userOption;
    }

    public UserOption recognizeUserOption(String userOption) {
        return UserOption.valueOf(userOption);
    }
}
