package com.akpanda.ludo.core;

import com.akpanda.ludo.components.Game;
import com.akpanda.ludo.components.board.Box;
import com.akpanda.ludo.components.board.CommonPathBox;
import com.akpanda.ludo.components.board.HomePathBox;
import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.players.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;


@Component
public class LudoCoreFunctionalities {
    Logger logger = LoggerFactory.getLogger(LudoCoreFunctionalities.class);

    public int rollDice(String playerName){
        int diceOutput = ((int) (Math.random()*(LudoConstants.MAX_DIE_VALUE - LudoConstants.MIN_DIE_VALUE))) + LudoConstants.MIN_DIE_VALUE;
        logger.info("Dice output for : "+playerName+" : "+diceOutput);
        return diceOutput;
    }

    public Map<LudoPiece, Box> detectMovablePlayers(Player currentPlayer, int diceValue){
        Map<LudoPiece,Box> eligiblePieces = new HashMap<>();
        eligiblePieces = (Map<LudoPiece, Box>) currentPlayer.getPlayerPieces().entrySet().stream()
                .filter(currentPiece -> {
                    if(currentPiece.getValue() != null)
                        if(currentPiece.getValue() instanceof CommonPathBox)
                            return true;
                        else if(currentPiece.getValue() instanceof HomePathBox){
                            HomePathBox head = (HomePathBox) currentPiece.getValue();
                            int validSteps = 1;
                            while (head.getNext() != null){
                                validSteps++;
                                head = head.getNext();
                            }
                            if(validSteps <=  diceValue)
                                return true;
                        }
                        else if(currentPiece.getValue() == null && diceValue==6)
                            return true;
                        return false;
                });
        return eligiblePieces;
    }

    public boolean checkIfWinner(Player currentPlayer){
        if(currentPlayer.getFinishedPieces() == 4)
            return true;
        else
            return false;
    }

    public boolean killPiece(LudoPiece currentPiece, Box currentBox, List<Player> otherPlayers){
        AtomicBoolean killed = new AtomicBoolean(false);
        if(currentBox instanceof CommonPathBox){
            CommonPathBox commonPathBox = (CommonPathBox) currentBox;
            if(!commonPathBox.isSafeBox()){
                otherPlayers.stream().forEach(player -> {
                    player.getPlayerPieces().entrySet()
                            .stream()
                            .forEach(playerPiece ->{
                                if(playerPiece.getValue()==currentBox){
                                    playerPiece.setValue(null);
                                    killed.set(true);
                                }
                            });
                    });
                }
        }
        return killed.get();
    }

    public void movePiece(LudoPiece selectedPiece, int diceRoll, Player currentPlayer){
        currentPlayer.getPlayerPieces().entrySet().forEach(currentPiece -> {
            if(currentPiece.getKey() == selectedPiece){
                if(currentPiece.getValue() instanceof HomePathBox){
                    HomePathBox temp = (HomePathBox) currentPiece.getValue();
                    for(int i =1;i<=diceRoll;i++){
                        temp = temp.getNext();
                        currentPiece.setValue(temp);
                        if(temp.getNext()==null){
                            currentPlayer.setFinishedPieces(currentPlayer.getFinishedPieces()+1);
                        }
                    }
                }
                else if(currentPiece.getValue()==null){
                    if(currentPlayer instanceof BluePlayer)
                        currentPiece.setValue(((BluePlayer) currentPlayer).getBluePart().getStartPoint());
                    if(currentPlayer instanceof RedPlayer)
                        currentPiece.setValue(((RedPlayer) currentPlayer).getRedPart().getStartPoint());
                    if(currentPlayer instanceof GreenPlayer)
                        currentPiece.setValue(((GreenPlayer) currentPlayer).getGreenPart().getStartPoint());
                    if(currentPlayer instanceof YellowPlayer)
                        currentPiece.setValue(((YellowPlayer) currentPlayer).getYellowPart().getStartPoint());
                }
                else{
                    CommonPathBox temp = (CommonPathBox) currentPiece.getValue();
                    if(temp.isHasGatewayToHome() && temp.getColor()==selectedPiece.getPieceColor()){
                        HomePathBox homeTemp = temp.getGateWayToHome();
                        for(int i=1;i<diceRoll;i++){
                            homeTemp = homeTemp.getNext();
                        }
                        currentPiece.setValue(homeTemp);
                        if(homeTemp.getNext() == null){
                            currentPlayer.setFinishedPieces(currentPlayer.getFinishedPieces()+1);
                        }
                    }
                    else{
                        int i=1;
                        boolean enteredHome = false;
                        HomePathBox headerHomeBox = null;
                        while (i<=diceRoll){
                            i++;
                            temp = temp.getNextNode();
                            if(temp.isHasGatewayToHome() && temp.getGateWayToHome().getColor() == selectedPiece.getPieceColor())
                                break;
                        }
                        if(i<diceRoll){
                            enteredHome = true;
                            headerHomeBox = temp.getGateWayToHome();
                            while(i<=diceRoll){
                               i++;
                               headerHomeBox = headerHomeBox.getNext();
                            }
                        }
                        if(enteredHome)
                            currentPiece.setValue(headerHomeBox);
                        else
                            currentPiece.setValue(temp);
                    }
                }
            }
        });
    }



}
