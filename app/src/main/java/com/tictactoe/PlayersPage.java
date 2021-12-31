package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayersPage extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_page);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }
    public void submitButtonClicked (View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent openGamePage = new Intent(this, GamePage.class);
        openGamePage.putExtra("PLAYER_NAMES", new String[]{player1Name,player2Name});
        startActivity(openGamePage);
    }
}