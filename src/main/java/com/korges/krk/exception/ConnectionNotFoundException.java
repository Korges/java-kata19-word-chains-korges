package com.korges.krk.exception;

public class ConnectionNotFoundException extends Exception {

    public ConnectionNotFoundException() {
        System.out.println("Connection not found");
    }
}
