package org.effectivejava.examples.chapter11.item77;


import java.io.Serializable;

public class Animal implements Serializable{
    public String name;

    public Animal() {
    }

    private void readObjectNoData() {
        this.name = "zhangsan";
    }
}
