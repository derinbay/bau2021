package com.bau.test.users;

public class UserPool {

    public static User getValidUser() {
        return new User("email", "1234567a");
    }

    public static User getUserWithWrongPassword() {
        return new User("email", "dghsajkldas");
    }

    public static User getUserWithEmptyPassword() {
        return new User("email", "");
    }

    public static User getUserWithEmptyEmailAndPassword() {
        return new User("", "");
    }
}
