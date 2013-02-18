package com.ruoli.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.ruoli.controller.GameController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 09/02/2013
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class GameActivity extends Activity implements View.OnClickListener {
    ImageButton gridTopLeft, gridTopMid, gridTopRight, gridMidLeft, gridMidMid, gridMidRight, gridButtomLeft, gridButtonMid, gridButtonRight;
    Button cleanButton;
    GameController gameController;

    List<ImageButton> imageButtonList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameactivity);

//        GridView gridView = (GridView)findViewById(R.id.gridview);
//        gridView.setAdapter(new ImageAdapter(this));
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(GameActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });

        gridTopLeft = (ImageButton)findViewById(R.id.foodImageTopLeft);
        gridTopLeft.setOnClickListener(this);
        gridTopMid = (ImageButton)findViewById(R.id.foodImageTopMid);
        gridTopMid.setOnClickListener(this);
        gridTopRight = (ImageButton)findViewById(R.id.foodImageTopRight);
        gridTopRight.setOnClickListener(this);

        gridMidLeft = (ImageButton)findViewById(R.id.foodImageMidleft);
        gridMidLeft.setOnClickListener(this);
        gridMidMid = (ImageButton)findViewById(R.id.foodImageMidMid);
        gridMidMid.setOnClickListener(this);
        gridMidRight = (ImageButton)findViewById(R.id.foodImageMidRight);
        gridMidRight.setOnClickListener(this);

        gridButtomLeft = (ImageButton)findViewById(R.id.foodImageButtomLeft);
        gridButtomLeft.setOnClickListener(this);
        gridButtonMid = (ImageButton)findViewById(R.id.foodImageButtomMid);
        gridButtonMid.setOnClickListener(this);
        gridButtonRight = (ImageButton)findViewById(R.id.foodImageButtomRight);
        gridButtonRight.setOnClickListener(this);

        cleanButton = (Button)findViewById(R.id.cleanButton);
        cleanButton.setOnClickListener(this);

        gameController = new GameController();

        initImageButtonList();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.foodImageTopLeft:
                if (!gameController.isRatAlreadyHasFood(0, 0)) {
                    gameController.addFoodToGridAndCheckWinnder(0, 0);
                    drawFood(gridTopLeft, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageTopMid:
                if (!gameController.isRatAlreadyHasFood(0, 1)) {
                    gameController.addFoodToGridAndCheckWinnder(0, 1);
                    drawFood(gridTopMid, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageTopRight:
                if (!gameController.isRatAlreadyHasFood(0, 2)) {
                    gameController.addFoodToGridAndCheckWinnder(0, 2);
                    drawFood(gridTopRight, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageMidleft:
                if (!gameController.isRatAlreadyHasFood(1, 0)) {
                    gameController.addFoodToGridAndCheckWinnder(1, 0);
                    drawFood(gridMidLeft, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageMidMid:
                if (!gameController.isRatAlreadyHasFood(1, 1)) {
                    gameController.addFoodToGridAndCheckWinnder(1, 1);
                    drawFood(gridMidMid, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageMidRight:
                if (!gameController.isRatAlreadyHasFood(1, 2)) {
                    gameController.addFoodToGridAndCheckWinnder(1, 2);
                    drawFood(gridMidRight, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageButtomLeft:
                if (!gameController.isRatAlreadyHasFood(2, 0)) {
                    gameController.addFoodToGridAndCheckWinnder(2, 0);
                    drawFood(gridButtomLeft, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageButtomMid:
                if (!gameController.isRatAlreadyHasFood(2, 1)) {
                    gameController.addFoodToGridAndCheckWinnder(2, 1);
                    drawFood(gridButtonMid, v);
                    winningMsg();
                }
                break;

            case R.id.foodImageButtomRight:
                if (!gameController.isRatAlreadyHasFood(2, 2)) {
                    gameController.addFoodToGridAndCheckWinnder(2, 2);
                    drawFood(gridButtonRight, v);
                    winningMsg();
                }
                break;

            case R.id.cleanButton:
                for (int i=0; i <imageButtonList.size(); i++)
                     cleanGameMap(imageButtonList.get(i), v);
                break;
        }
    }

    private void cleanGameMap(ImageButton ib, View v) {
        ib.setImageDrawable(v.getResources().getDrawable(R.drawable.listempty));
        gameController.clearMap();
    }

    private void drawFood(ImageButton ib, View v) {
        if(gameController.getActualFoodMsgForGUI().equals("o")){
                ib.setImageDrawable(v.getResources().getDrawable(R.drawable.bean));
        }
        else{
                ib.setImageDrawable(v.getResources().getDrawable(R.drawable.cheese));
        }
    }

    private void initImageButtonList(){
        imageButtonList = new ArrayList<ImageButton>();

        imageButtonList.add(gridTopLeft);
        imageButtonList.add(gridTopMid);
        imageButtonList.add(gridTopRight);

        imageButtonList.add(gridMidLeft);
        imageButtonList.add(gridMidMid);
        imageButtonList.add(gridMidRight);

        imageButtonList.add(gridButtomLeft);
        imageButtonList.add(gridButtonMid);
        imageButtonList.add(gridButtonRight);

    }

    private void winningMsg(){
        if(gameController.getWinner().equals("O wins the game"))
            Toast.makeText(getApplicationContext(), "Rat eats Bean!", Toast.LENGTH_LONG).show();
        else if (gameController.getWinner().equals("X wins the game"))
            Toast.makeText(getApplicationContext(), "Rat eats Cheese!", Toast.LENGTH_LONG).show();
        else if (gameController.getWinner().equals("Draw Game"))
            Toast.makeText(getApplicationContext(), "Draw Game", Toast.LENGTH_LONG).show();
    }
}