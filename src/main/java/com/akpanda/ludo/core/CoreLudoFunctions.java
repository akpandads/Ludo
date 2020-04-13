package com.akpanda.ludo.core;

import com.akpanda.ludo.components.board.HomeBoxLinkedList;
import com.akpanda.ludo.components.board.SingleHomeBox;
import com.akpanda.ludo.components.enums.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CoreLudoFunctions {

    Logger logger = LoggerFactory.getLogger(CoreLudoFunctions.class);

    public int rollDice(String playerName){
        int diceOutput = ((int) (Math.random()*(LudoConstants.MAX_DIE_VALUE - LudoConstants.MIN_DIE_VALUE))) + LudoConstants.MIN_DIE_VALUE;
        logger.info("Dice output for : "+playerName+" : "+diceOutput);
        return diceOutput;
    }

    public void initializeBoard(){
        HomeBoxLinkedList blueHomePath = initializeHomePath(Color.BLUE);
        HomeBoxLinkedList redHomePath = initializeHomePath(Color.RED);
        HomeBoxLinkedList greenHomePath = initializeHomePath(Color.GREEN);
        HomeBoxLinkedList yellowHomePath = initializeHomePath(Color.YELLOW);
    }

    private HomeBoxLinkedList initializeHomePath(Color color) {
        HomeBoxLinkedList homeBoxLinkedList = new HomeBoxLinkedList();
        SingleHomeBox singleHomeBox = new SingleHomeBox();
        singleHomeBox.setNext(null);
        singleHomeBox.setFinalBox(false);
        singleHomeBox.setColor(color);
        singleHomeBox.setPosition(1);
        SingleHomeBox pointer = singleHomeBox;
        for(int i=2 ;i<=LudoConstants.HOME_PATH_LENGTH;i++){
            SingleHomeBox tempBox = new SingleHomeBox();
            tempBox.setColor(color);
            tempBox.setFinalBox(false);
            tempBox.setNext(null);
            tempBox.setPosition(i);
            pointer.setNext(tempBox);
            pointer = tempBox;
            if(i==6){
                tempBox.setFinalBox(true);
                tempBox.setNext(null);
            }
        }
        homeBoxLinkedList.setStart(singleHomeBox);
        return homeBoxLinkedList;
    }
}
