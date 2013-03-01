package com.ruoli.controller;

import com.ruoli.npc.NPC;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 10/02/2013
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class GameController extends Grid{  //extend grid, make abstract

    String foodTypeForBackend, actualFoodMsgForGUI;
    Boolean oTurn = true;
    Boolean npcsTurn = true;
    String winner = "";

    public GameController(){
        super();
        foodTypeForBackend = checkWhoMovesFirst();
    }

    private String checkWhoMovesFirst() {
        String s = null;
        if (super.initCheckGridIsEmpty())
            s = "o";
        return s;
    }

    public void addFoodToGrid(int x, int y) {
        npcsTurn=true;
        gameMovementLogic(x,y);
    }

    private void gameMovementLogic(int x, int y){
        if (oTurn) {
            super.addObjectToMap(x, y, foodTypeForBackend);
            oTurn = false;
            actualFoodMsgForGUI = "o";
            foodTypeForBackend = "x";
            winner = super.checkTheWinner();
        } else {
            super.addObjectToMap(x, y, foodTypeForBackend);
            oTurn = true;
            actualFoodMsgForGUI = "x";
            foodTypeForBackend = "o";
            winner = super.checkTheWinner();
        }
    }

    public String getActualFoodMsgForGUI() {
        return actualFoodMsgForGUI;
    }

    public String getWinner() {
        return winner;
    }

    public Boolean isRatAlreadyHasFood(int x, int y){
        return (!super.getObjectFromCertainPosition(x, y).equals(""));
    }

    public void npcMove(){
        NPC npc = new NPC();
        if(npcsTurn){
            int x = npc.getX();
            int y = npc.getY();
            if (!isRatAlreadyHasFood(x,y)){
                gameMovementLogic(x,y);
                winner = super.checkTheWinner();
                npcsTurn=false;
            }
            else {
                npcMove();
            }

        }
    }
}
