package org.effectivejava.examples.chapter11.item74;


import org.effectivejava.examples.chapter11.item77.Elvis;
import org.effectivejava.examples.chapter11.item77.ElvisStealer;
import org.effectivejava.examples.chapter11.item77.enumSingleton.ElvisEnum;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonTest {
    @Test
    public void shouldBreakElvis() throws Exception {
        Elvis elvis = Elvis.INSTANCE;
        elvis.printFavorites();
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("elvis.bin"));
        output.writeObject(elvis);
        output.close();

        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("elvis.bin"));
        Elvis otherElvis = (Elvis) input.readObject();
        otherElvis.printFavorites();

        Assert.assertEquals(elvis, otherElvis);
    }

    @Test
    public void shouldNotBreakElvisEnum() throws Exception {
        ElvisEnum elvis = ElvisEnum.INSTANCE;
        elvis.printFavorites();
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("elvis-enum.bin"));
        output.writeObject(elvis);
        output.close();

        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("elvis-enum.bin"));
        ElvisEnum otherElvis = (ElvisEnum) input.readObject();
        otherElvis.printFavorites();

        Assert.assertEquals(elvis, otherElvis);

    }

    @Test
    public void shouldAttackElvis() throws Exception {
        Elvis elvis = Elvis.INSTANCE;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("elvis.bin"));
        output.writeObject(elvis);
        output.close();

        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("elvis.bin"));
        elvis = (Elvis) input.readObject();

        Elvis impersonator = ElvisStealer.impersonator;
        elvis.printFavorites();
        impersonator.printFavorites();

    }
}
