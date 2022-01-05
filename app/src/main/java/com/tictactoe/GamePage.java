package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePage extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard; //this variable calls the methods in TicTacToeBoard.java specifically for reset
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);


        Button playAgainBTN = findViewById(R.id.play_again); //check this on the setUpGame method in TicTacToeBoard.java
        Button homeBTN = findViewById(R.id.home_button); //check this on the setUpGame method in TicTacToeBoard.java
        TextView playerTurn = findViewById(R.id.player_display); //check this on the setUpGame method in TicTacToeBoard.java

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES"); //check this on the setUpGame method in TicTacToeBoard.java

        if (playerNames != null){
            playerTurn.setText((playerNames[0]+"'s Starts"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard2); //find the view of the tictactoeboard and store in that var
        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);
    }
    public void playAgainButtonClicked (View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public void homeButtonClicked (View view){
        Intent openMainActivity = new Intent(this, MainActivity.class);
        startActivity(openMainActivity);
    }
}