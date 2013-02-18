package com.ruoli.controller;

public class Grid
{
    final int mapSize = 3;
    private String map[][];

    public Grid(){
        map = new String[mapSize][mapSize];
        this.clearMap();
    }



    public Boolean initCheckGridIsEmpty(){
        boolean notEmpty = false;
        for(String[] array: map){
            for(String val: array){
                if(!val.equals("")){
                    notEmpty=true;
                    break;
                }
            }
        }
        if (notEmpty)
            return false;
        else
            return true;
    }

    public void addObjectToMap(int x, int y, String xo) {
        if(getObjectFromCertainPosition(x,y).equals("") && (!checkTheWinner().equals("O wins the game") || !checkTheWinner().equals("x wins the game")))
            map[x][y] = xo;
    }

    public String getObjectFromCertainPosition(int x, int y) {
        return map[x][y];
    }

    public void clearMap() {
        for(int i=0; i< mapSize; i++){
            for(int j=0; j< mapSize; j++){
                map[i][j] = "";
            }
        }
    }

    public String checkTheWinner() {
        for(int i = 0; i < mapSize; i++)
        {
            if(isOTheWinner(i))
                return "O wins the game";

            else if (isXTheWinner(i))
                return "X wins the game";
            else if (isGameBoardFiledAndDrawGame() && !isOTheWinner(i) && !isXTheWinner(i))
                return "Draw Game";
        }
        return "No winner";
    }

    private Boolean isOTheWinner(int i){
        return (getHorizontal(i).equals("ooo") || getVertical(i).equals("ooo") || getDiagonal(i).equals("ooo"));
    }

    private Boolean isXTheWinner(int i){
        return (getHorizontal(i).equals("xxx") || getVertical(i).equals("xxx") || getDiagonal(i).equals("xxx"));
    }

    private Boolean isGameBoardFiledAndDrawGame(){
        Boolean isFilled = true;
        for (String[] array: map){
            for (String val: array){
                if (val.equals("")){
                    isFilled=false;
                    break;
                }
            }
        }
        if (isFilled)
            return true;
        else
            return false;
    }

    private String getHorizontal(int row)
    {
        String line = "";

        line = getObjectFromCertainPosition(row,0)
                + getObjectFromCertainPosition(row,1)
                + getObjectFromCertainPosition(row,2);

        return line;
    }


    private String getVertical(int column)
    {
        String line = "";

        line = getObjectFromCertainPosition(0,column)
                + getObjectFromCertainPosition(1,column)
                + getObjectFromCertainPosition(2,column);

        return line;
    }

    private String getDiagonal(int diagonalOption)
    {
        String line = "";
        if(diagonalOption < 1)
        {
            line = getObjectFromCertainPosition(0,0)
                    + getObjectFromCertainPosition(1,1)
                    + getObjectFromCertainPosition(2,2);
        }
        else
        {
            line = getObjectFromCertainPosition(0,2)
                    + getObjectFromCertainPosition(1,1)
                    + getObjectFromCertainPosition(2,0);
        }
        return line;
    }


}