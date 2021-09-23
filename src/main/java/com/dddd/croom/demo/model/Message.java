package com.dddd.croom.demo.model;

import java.util.List;

public class Message {

    private String user;
    private String action;
    private String content;
    private boolean hand_state;
    private List<User> users;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHand_state() {
        return hand_state;
    }

    public void setHand_state(boolean hand_state) {
        this.hand_state = hand_state;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}