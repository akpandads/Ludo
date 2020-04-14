package com.akpanda.ludo.core;

import com.akpanda.ludo.components.board.*;
import com.akpanda.ludo.components.enums.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LudoBoardSetup {

    Logger logger = LoggerFactory.getLogger(LudoBoardSetup.class);


    public void initializeBoard(){
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

    }

    private void joinParts(LudoBoardPart firstQuadrant, LudoBoardPart secondQuadrant) {
        SingleBox pointer = firstQuadrant.getStartPoint();
        while(pointer.getNextNode() !=null){
            pointer = pointer.getNextNode();
        }
        pointer.setNextNode(secondQuadrant.getStartPoint());
    }

    private LudoBoardPart initializeCommonPath(Color color, HomeBoxLinkedList nextColorHomePath) {
        LudoBoardPart ludoBoardPart = new LudoBoardPart();
        SingleBox singleBox = new SingleBox();
        singleBox.setBoxColor(color);
        singleBox.setStartBox(true);
        singleBox.setGateWayToHome(null);
        singleBox.setHasGatewayToHome(false);
        singleBox.setSafeBox(true);
        singleBox.setNextNode(null);
        SingleBox pointer = singleBox;
        for(int i=2;i<=13;i++){
            SingleBox tempBox = new SingleBox();
            tempBox.setBoxColor(Color.WHITE);
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
        ludoBoardPart.setStartPoint(singleBox);
        return ludoBoardPart;
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
