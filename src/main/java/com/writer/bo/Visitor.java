package com.writer.bo;
//https://stackoverflow.com/questions/51218227/user-class-for-spring-security-application
//https://spring.io/guides/tutorials/spring-security-and-angular-js/
//https://github.com/eugenp/tutorials/blob/master/spring-web-modules/spring-mvc-basics/src/main/java/com/baeldung/model/User.java
public class Visitor extends User{
    public Visitor(String firstName, String lastName, String username, String email, String role) {
        super(firstName, lastName, username, email, role);
    }
}
