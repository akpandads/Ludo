package com.akpanda.ludo.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LudoCoreFunctionalities {
    Logger logger = LoggerFactory.getLogger(LudoCoreFunctionalities.class);

    public int rollDice(String playerName){
        int diceOutput = ((int) (Math.random()*(LudoConstants.MAX_DIE_VALUE - LudoConstants.MIN_DIE_VALUE))) + LudoConstants.MIN_DIE_VALUE;
        logger.info("Dice output for : "+playerName+" : "+diceOutput);
        return diceOutput;
    }
}
