package com.akpanda.ludo.core;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCoreLudoFunctions {

    @Autowired
    CoreLudoFunctions coreLudoFunctions;

    @Test
    public void testRollDice(){
        int randomNumber = coreLudoFunctions.rollDice("no name");
        Assert.assertTrue(randomNumber>=1 && randomNumber<=6);
    }

    @Test
    public void testHomeBoxPath(){
        coreLudoFunctions.initializeBoard();
    }
}
