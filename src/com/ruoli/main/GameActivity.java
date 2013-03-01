package com.ruoli.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ruoli.controller.GameController;
import com.ruoli.npc.NPC;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 09/02/2013
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class GameActivity extends Activity implements View.OnClickListener {
    ImageButton gridTopLeft, gridTopMid, gridTopRight, gridMidLeft, gridMidMid, gridMidRight, gridButtomLeft, gridButtonMid, gridButtonRight;
    //Button cleanButton;
    GameController gameController;

    List<ImageButton> imageButtonList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameactivity);

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

//        cleanButton = (Button)findViewById(R.id.cleanButton);
//        cleanButton.setOnClickListener(this);

        gameController = new GameController();

        initImageButtonList();

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.foodImageTopLeft:
                gameMapStatusObserver(0,0,gridTopLeft,v);
                npcMovement(v);
                break;

            case R.id.foodImageTopMid:
                gameMapStatusObserver(0,1,gridTopMid,v);
                npcMovement(v);
                break;

            case R.id.foodImageTopRight:
                gameMapStatusObserver(0,2,gridTopRight,v);
                npcMovement(v);
                break;

            case R.id.foodImageMidleft:
                gameMapStatusObserver(1,0,gridMidLeft,v);
                npcMovement(v);
                break;

            case R.id.foodImageMidMid:
                gameMapStatusObserver(1,1,gridMidMid,v);
                npcMovement(v);
                break;

            case R.id.foodImageMidRight:
                gameMapStatusObserver(1,2,gridMidRight,v);
                npcMovement(v);
                break;

            case R.id.foodImageButtomLeft:
                gameMapStatusObserver(2,0,gridButtomLeft,v);
                npcMovement(v);
                break;

            case R.id.foodImageButtomMid:
                gameMapStatusObserver(2,1,gridButtonMid,v);
                npcMovement(v);
                break;

            case R.id.foodImageButtomRight:
                gameMapStatusObserver(2,2,gridButtonRight,v);
                npcMovement(v);
                break;
        }
    }

    private void npcMovement(View v) {
        NPC npc = new NPC();
        int x = npc.getX();
        int y = npc.getY();
        Random random = new Random();
        int listPosition = random.nextInt(8);
        ImageButton ib = imageButtonList.get(listPosition);
        gameMapStatusObserver(x,y,ib,v);
    }

    private void gameMapStatusObserver(int x, int y, ImageButton ib, View v){
        if (!gameController.isRatAlreadyHasFood(x, y)) {
            gameController.addFoodToGrid(x, y);
            drawFood(ib, v);
            winningMsg();
            gameController.checkIsGameEndedYet();
        }
    }

    private void drawFood(ImageButton ib, View v) {
        if(gameController.getActualFoodMsgForGUI().equals("o")){
                ib.setImageDrawable(v.getResources().getDrawable(R.drawable.bean));
        }
        else{
                ib.setImageDrawable(v.getResources().getDrawable(R.drawable.cheese));
        }
    }

    private void winningMsg(){
        if(gameController.getWinner().equals("O wins the game"))
            Toast.makeText(getApplicationContext(), "Rat eats Bean!", Toast.LENGTH_LONG).show();
        else if (gameController.getWinner().equals("X wins the game"))
            Toast.makeText(getApplicationContext(), "Rat eats Cheese!", Toast.LENGTH_LONG).show();
        else if (gameController.getWinner().equals("Draw Game"))
            Toast.makeText(getApplicationContext(), "Draw Game", Toast.LENGTH_LONG).show();
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
        case R.id.cleanButton:
            for (int i=0; i <imageButtonList.size(); i++)
                 cleanGameMap(imageButtonList.get(i));
            return true;
        
        default:
        	return super.onOptionsItemSelected(item);
		}
		
	}
	
    private void cleanGameMap(ImageButton ib) {
        ib.setImageDrawable(getResources().getDrawable(R.drawable.listempty));
        gameController.clearMap();
    }

}
