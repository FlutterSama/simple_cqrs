package com.ideanet.simple_cqrs.command;

public class CreateUserCommand {

    private String name;
    private String email;

    public CreateUserCommand(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
