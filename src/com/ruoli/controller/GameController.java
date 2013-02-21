package com.ruoli.controller;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 10/02/2013
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class GameController extends Grid{  //extend grid, make abstract

    String LogicFoodType, actualFoodMsgForGUI;
    Boolean oTurn = true;
    String winner = "";

    public GameController(){
        super();
        LogicFoodType = checkWhoMovesFirst();
    }

    private String checkWhoMovesFirst() {
        String s = null;
        if (super.initCheckGridIsEmpty())
            s = "o";
        return s;
    }

    public void addFoodToGrid(int x, int y) { //point class, and refact
        if (oTurn) {
            super.addObjectToMap(x, y, LogicFoodType);
            oTurn = false;
            actualFoodMsgForGUI = "o";
            LogicFoodType = "x";
            winner = super.checkTheWinner();
        } else {
            super.addObjectToMap(x, y, LogicFoodType);
            oTurn = true;
            actualFoodMsgForGUI = "x";
            LogicFoodType = "o";
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


}
