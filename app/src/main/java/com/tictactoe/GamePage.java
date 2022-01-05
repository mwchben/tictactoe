package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GamePage extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard; //this variable calls the methods in TicTacToeBoard.java specifically for reset
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard2); //find the view of the tictactoeboard and store in that var
    }
    public void playAgainButtonClicked (View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public void returnButtonClicked (View view){
        Intent openMainActivity = new Intent(this, MainActivity.class);
        startActivity(openMainActivity);
    }
}