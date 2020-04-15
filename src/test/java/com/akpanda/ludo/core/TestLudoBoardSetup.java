package com.akpanda.ludo.core;


import com.akpanda.ludo.components.Game;
import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.board.SingleBox;
import com.akpanda.ludo.components.board.SingleHomeBox;
import com.akpanda.ludo.components.enums.Color;
import com.akpanda.ludo.components.players.BluePlayer;
import com.akpanda.ludo.components.players.GreenPlayer;
import com.akpanda.ludo.components.players.RedPlayer;
import com.akpanda.ludo.components.players.YellowPlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLudoBoardSetup {

    @Autowired
    LudoBoardSetup ludoBoardSetup;

    @Test
    public void testInitializeBoardIsCircularAndHas52CommonSquares(){
        Game game = ludoBoardSetup.initializeBoard("red","blue","green","yellow");
        RedPlayer redPlayer = game.getRedPlayer();
        GreenPlayer greenPlayer = game.getGreenPlayer();
        YellowPlayer yellowPlayer = game.getYellowPlayer();
        BluePlayer bluePlayer = game.getBluePlayer();

        SingleBox redStartPoint = redPlayer.getRedPart().getStartPoint();
        SingleBox redHead = redPlayer.getRedPart().getStartPoint();
        int redCount=1;
        while(redHead.getNextNode() != redStartPoint){
            redCount++;
            redHead = redHead.getNextNode();
        }

        SingleBox blueStartPoint = bluePlayer.getBluePart().getStartPoint();
        SingleBox blueHead = bluePlayer.getBluePart().getStartPoint();
        int blueCount=1;
        while(blueHead.getNextNode() != blueStartPoint){
            blueCount++;
            blueHead = blueHead.getNextNode();
        }
        Assert.assertEquals(blueCount,52);

        SingleBox greenStartPoint = greenPlayer.getGreenPart().getStartPoint();
        SingleBox greenHead = greenPlayer.getGreenPart().getStartPoint();
        int greenCount=1;
        while(greenHead.getNextNode() != greenStartPoint){
            greenCount++;
            greenHead = greenHead.getNextNode();
        }
        Assert.assertEquals(greenCount,52);

        SingleBox yellowStartPoint = yellowPlayer.getYellowPart().getStartPoint();
        SingleBox yellowHead = yellowPlayer.getYellowPart().getStartPoint();
        int yellowCount=1;
        while(yellowHead.getNextNode() != yellowStartPoint){
            yellowCount++;
            yellowHead = yellowHead.getNextNode();
        }
        Assert.assertEquals(yellowCount,52);
    }

    @Test
    public void testInitializeBoardHasLinkToHomePathAndIsOf6Squares() {
        Game game = ludoBoardSetup.initializeBoard("red", "blue", "green", "yellow");
        RedPlayer redPlayer = game.getRedPlayer();
        GreenPlayer greenPlayer = game.getGreenPlayer();
        YellowPlayer yellowPlayer = game.getYellowPlayer();
        BluePlayer bluePlayer = game.getBluePlayer();

        SingleBox redHead = redPlayer.getRedPart().getStartPoint();
        int redCount=1;
        int greenHomePathCOunt=1;
        while(!redHead.getNextNode().getNextNode().isStartBox()){
            redCount++;
            redHead = redHead.getNextNode();
        }
        Assert.assertEquals(redHead.isHasGatewayToHome(),true);
        Assert.assertNotNull(redHead.getGateWayToHome());
        Assert.assertEquals(12,redCount);
        Assert.assertTrue(redHead.getNextNode().getNextNode().getBoxColor().equals(Color.GREEN));

        SingleHomeBox greenHomeHead = redHead.getGateWayToHome();
        while(greenHomeHead.getNext()!=null){
            greenHomeHead = greenHomeHead.getNext();
            greenHomePathCOunt++;
        }
        Assert.assertEquals(6,greenHomePathCOunt);
        Assert.assertEquals(greenHomeHead.getNext(),null);
        Assert.assertTrue(greenHomeHead.isFinalBox());

        
        SingleBox greenHead = greenPlayer.getGreenPart().getStartPoint();
        int greenCount=1;
        int yellowHomePathCOunt=1;
        while(!greenHead.getNextNode().getNextNode().isStartBox()){
            greenCount++;
            greenHead = greenHead.getNextNode();
        }
        Assert.assertEquals(greenHead.isHasGatewayToHome(),true);
        Assert.assertNotNull(greenHead.getGateWayToHome());
        Assert.assertEquals(12,greenCount);
        Assert.assertTrue(greenHead.getNextNode().getNextNode().getBoxColor().equals(Color.YELLOW));
        SingleHomeBox yellowHomeHead = redHead.getGateWayToHome();
        while(yellowHomeHead.getNext()!=null){
            yellowHomeHead = yellowHomeHead.getNext();
            yellowHomePathCOunt++;
        }
        Assert.assertEquals(6,yellowHomePathCOunt);
        Assert.assertEquals(yellowHomeHead.getNext(),null);
        Assert.assertTrue(yellowHomeHead.isFinalBox());

        
        SingleBox yellowHead = yellowPlayer.getYellowPart().getStartPoint();
        int yellowCount=1;
        int blueHomePathCOunt=1;
        while(!yellowHead.getNextNode().getNextNode().isStartBox()){
            yellowCount++;
            yellowHead = yellowHead.getNextNode();
        }
        Assert.assertEquals(yellowHead.isHasGatewayToHome(),true);
        Assert.assertNotNull(yellowHead.getGateWayToHome());
        Assert.assertEquals(12,yellowCount);
        Assert.assertTrue(yellowHead.getNextNode().getNextNode().getBoxColor().equals(Color.BLUE));
        SingleHomeBox blueHomeHead = redHead.getGateWayToHome();
        while(blueHomeHead.getNext()!=null){
            blueHomeHead = blueHomeHead.getNext();
            blueHomePathCOunt++;
        }
        Assert.assertEquals(6,blueHomePathCOunt);
        Assert.assertEquals(blueHomeHead.getNext(),null);
        Assert.assertTrue(blueHomeHead.isFinalBox());

        
        SingleBox blueHead = bluePlayer.getBluePart().getStartPoint();
        int blueCount=1;
        int redHomePathCOunt=1;
        while(!blueHead.getNextNode().getNextNode().isStartBox()){
            blueCount++;
            blueHead = blueHead.getNextNode();
        }
        Assert.assertEquals(blueHead.isHasGatewayToHome(),true);
        Assert.assertNotNull(blueHead.getGateWayToHome());
        Assert.assertEquals(12,blueCount);
        Assert.assertTrue(blueHead.getNextNode().getNextNode().getBoxColor().equals(Color.RED));
        SingleHomeBox redHomeHead = redHead.getGateWayToHome();
        while(redHomeHead.getNext()!=null){
            redHomeHead = redHomeHead.getNext();
            redHomePathCOunt++;
        }
        Assert.assertEquals(6,redHomePathCOunt);
        Assert.assertEquals(redHomeHead.getNext(),null);
        Assert.assertTrue(redHomeHead.isFinalBox());

    }
}
