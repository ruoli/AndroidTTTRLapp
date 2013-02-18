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

    public void addFoodToGridAndCheckWinnder(int x, int y) { //point class, and refact
        if (oTurn) {
            isMyTurnDoTheMovement("o", "x", x, y);
            winner = super.checkTheWinner();
        } else {
            isMyTurnDoTheMovement("x", "o", x, y);
            winner = super.checkTheWinner();
            
        }

    }

    private void isMyTurnDoTheMovement(String foodForGUI, String foodForBackend, int gridPositionX, int gridPoistionY){
        super.addObjectToMap(gridPositionX, gridPoistionY, LogicFoodType);
        oTurn = false;
        actualFoodMsgForGUI = foodForGUI;
        LogicFoodType = foodForBackend;
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
