package com.example.classwork.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.swing.*;
@Entity(name = "ball")
public class Ball {
    @Id
    @Column(name = "ball_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ballID;

    @NotNull
    @Column(name = "size")
    private Integer size;

    @NotNull
    @Column(name = "weight")
    private Float weight;

    @NotNull
    @Column(name = "color")
    private String color;

    public Ball() {
    }

    public Long getBallID() {
        return ballID;
    }

    public void setBallID(Long ballID) {
        this.ballID = ballID;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
