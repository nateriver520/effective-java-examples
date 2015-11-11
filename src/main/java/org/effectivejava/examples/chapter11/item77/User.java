package org.effectivejava.examples.chapter11.item77;

import java.io.*;


public class User extends Animal implements Serializable {
    private int age;

    public User(int age) {
        this.age = age;
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("NoOject");
        this.age = 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
//        User user = new User(88);
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("user.bin"));
//        output.writeObject(user);
//        output.close();


        ObjectInputStream input = new ObjectInputStream(new FileInputStream("user.bin"));
        User newUser = (User) input.readObject();
        System.out.println(newUser.toString());
        System.out.println(newUser.name);

    }
}
