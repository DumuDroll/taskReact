package com.dddd.croom.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {

    private Long id;

    private String name;

    private boolean hand_up;

    public User() {

    }

    public User(String name) {
        this.name=name;
        this.hand_up=false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHand_up() {
        return hand_up;
    }

    public void setHand_up(boolean hand_up) {
        this.hand_up = hand_up;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
