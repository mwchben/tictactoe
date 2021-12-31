package com.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
    }
    public void playAgainButtonClicked (View view){
        //
    }
    public void returnButtonClicked (View view){
        Intent openMainActivity = new Intent(this, MainActivity.class);
        startActivity(openMainActivity);
    }
}