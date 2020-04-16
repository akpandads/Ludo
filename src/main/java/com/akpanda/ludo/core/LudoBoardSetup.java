package com.akpanda.ludo.core;

import com.akpanda.ludo.components.Game;
import com.akpanda.ludo.components.board.*;
import com.akpanda.ludo.components.enums.Color;
import com.akpanda.ludo.components.players.BluePlayer;
import com.akpanda.ludo.components.players.GreenPlayer;
import com.akpanda.ludo.components.players.RedPlayer;
import com.akpanda.ludo.components.players.YellowPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LudoBoardSetup {

    Logger logger = LoggerFactory.getLogger(LudoBoardSetup.class);


    public Game initializeBoard(String redName,String blueName, String greenName, String yellowName){

        Game game = new Game();
        LudoCoreFunctionalities ludoCoreFunctionalities = new LudoCoreFunctionalities();

        HomeBoxLinkedList blueHomePath = initializeHomePath(Color.BLUE);
        HomeBoxLinkedList redHomePath = initializeHomePath(Color.RED);
        HomeBoxLinkedList greenHomePath = initializeHomePath(Color.GREEN);
        HomeBoxLinkedList yellowHomePath = initializeHomePath(Color.YELLOW);

        LudoBoardPart greenPart = initializeCommonPath(Color.GREEN, redHomePath);
        LudoBoardPart yellowPart = initializeCommonPath(Color.YELLOW, blueHomePath);
        LudoBoardPart redPart = initializeCommonPath(Color.RED, yellowHomePath) ;
        LudoBoardPart bluePart = initializeCommonPath(Color.BLUE, greenHomePath);

        joinParts(redPart,greenPart);
        joinParts(greenPart,yellowPart);
        joinParts(yellowPart,bluePart);
        joinParts(bluePart,redPart);

        BluePlayer bluePlayer = new BluePlayer(Color.BLUE,blueName, bluePart);
        GreenPlayer greenPlayer = new GreenPlayer(Color.GREEN,greenName, greenPart);
        RedPlayer redPlayer = new RedPlayer(Color.RED,redName, redPart);
        YellowPlayer yellowPlayer = new YellowPlayer(Color.YELLOW,yellowName, yellowPart);

        game.setBluePlayer(bluePlayer);
        game.setGreenPlayer(greenPlayer);
        game.setRedPlayer(redPlayer);
        game.setYellowPlayer(yellowPlayer);
        game.setLudoCoreFunctionalities(ludoCoreFunctionalities);

        return game;
    }

    private void joinParts(LudoBoardPart firstQuadrant, LudoBoardPart secondQuadrant) {
        CommonPathBox pointer = firstQuadrant.getStartPoint();
        while(pointer.getNextNode() !=null){
            pointer = pointer.getNextNode();
        }
        pointer.setNextNode(secondQuadrant.getStartPoint());
    }

    private LudoBoardPart initializeCommonPath(Color color, HomeBoxLinkedList nextColorHomePath) {
        LudoBoardPart ludoBoardPart = new LudoBoardPart();
        CommonPathBox commonPathBox = new CommonPathBox();
        commonPathBox.setColor(color);
        commonPathBox.setStartBox(true);
        commonPathBox.setGateWayToHome(null);
        commonPathBox.setHasGatewayToHome(false);
        commonPathBox.setSafeBox(true);
        commonPathBox.setNextNode(null);
        CommonPathBox pointer = commonPathBox;
        for(int i=2;i<=13;i++){
            CommonPathBox tempBox = new CommonPathBox();
            tempBox.setColor(Color.WHITE);
            tempBox.setStartBox(false);
            if(i==9){
                tempBox.setGateWayToHome(null);
                tempBox.setHasGatewayToHome(false);
                tempBox.setSafeBox(true);
                pointer.setNextNode(tempBox);
                pointer = tempBox;
            }
            else if(i==12){
                tempBox.setGateWayToHome(nextColorHomePath.getStart());
                tempBox.setHasGatewayToHome(true);
                tempBox.setSafeBox(false);
                pointer.setNextNode(tempBox);
                pointer = tempBox;
            }
            else if(i==13){
                tempBox.setGateWayToHome(null);
                tempBox.setHasGatewayToHome(false);
                tempBox.setSafeBox(false);
                pointer.setNextNode(tempBox);
                tempBox.setNextNode(null);
            }
            else{
                tempBox.setGateWayToHome(null);
                tempBox.setHasGatewayToHome(false);
                tempBox.setSafeBox(false);
                pointer.setNextNode(tempBox);
                pointer = tempBox;
            }
        }
        ludoBoardPart.setStartPoint(commonPathBox);
        return ludoBoardPart;
    }

    private HomeBoxLinkedList initializeHomePath(Color color) {
        HomeBoxLinkedList homeBoxLinkedList = new HomeBoxLinkedList();
        HomePathBox homePathBox = new HomePathBox();
        homePathBox.setNext(null);
        homePathBox.setFinalBox(false);
        homePathBox.setColor(color);
        HomePathBox pointer = homePathBox;
        for(int i=2 ;i<=LudoConstants.HOME_PATH_LENGTH;i++){
            HomePathBox tempBox = new HomePathBox();
            tempBox.setColor(color);
            tempBox.setFinalBox(false);
            tempBox.setNext(null);
            pointer.setNext(tempBox);
            pointer = tempBox;
            if(i==6){
                tempBox.setFinalBox(true);
                tempBox.setNext(null);
            }
        }
        homeBoxLinkedList.setStart(homePathBox);
        return homeBoxLinkedList;
    }
}
