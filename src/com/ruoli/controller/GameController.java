package com.ruoli.controller;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 10/02/2013
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class GameController {  //extend grid, make abstract
    Grid grid;
    String LogicFoodType, actualFoodMsgForGUI;
    Boolean oTurn = true;
    String winner = "";

    public GameController(){
        grid = new Grid();
        LogicFoodType = checkWhoMovesFirst();
    }

    private String checkWhoMovesFirst() {
        String s = null;
        if (grid.initCheckGridIsEmpty())
            s = "o";
        return s;
    }

    public void addFood(int x, int y) { //point class, and refact
        if (oTurn){
                grid.addObjectToMap(x,y, LogicFoodType);
                oTurn = false;
                actualFoodMsgForGUI = "o";
                LogicFoodType = "x";
                winner = grid.checkTheWinner();
        }
        else{
                grid.addObjectToMap(x,y, LogicFoodType);
                oTurn = true;
                actualFoodMsgForGUI = "x";
                LogicFoodType ="o";
                winner = grid.checkTheWinner();
        }

    }

    public String getActualFoodMsgForGUI() {
        return actualFoodMsgForGUI;
    }

    public void cleanGameMap(){
        grid.clearMap();
    }

    public String getWinner() {
        return winner;
    }

    public Boolean isRatAlreadyHasFood(int x, int y){
        return (!grid.getObjectFromCertainPosition(x, y).equals(""));
    }
}
