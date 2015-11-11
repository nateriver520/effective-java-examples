package org.effectivejava.examples.chapter11.item74;


import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicTest {
    @Test
    public void shouldFooCanSuccSer() throws Exception {
        // serialization
        Foo foo = new Foo(99, 88);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("foo.bin"));
        output.writeObject(foo);
        output.close();

    }

    @Test
    public void shouldFooCanDes() throws Exception {
        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("foo.bin"));
        Foo otherFoo = (Foo) input.readObject();

        Assert.assertEquals(otherFoo.getX(), 99);
        Assert.assertEquals(otherFoo.getY(), 88);
    }
}
