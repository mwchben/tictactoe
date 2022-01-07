package com.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private int [][] gameBoard;

    private int [] winType = {-1,-1,-1}; //row,col,lineType

    private String[] playerNames = {"Player One","Player Two"};
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    private int  player = 1;


    //constructor with a 2D array that  will populate with holding  postn values
    GameLogic(){
        gameBoard = new int[3][3];

        //tells our gameboard this are the spots available to be played with
        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                gameBoard[r][c]=0;
            }
        }
    }

    public  boolean updateGameBoard(int row,int col){
        if (gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1] = player;

            if (player == 1){
                playerTurn.setText((playerNames[1] + "'s turn"));
            }
            else {
                playerTurn.setText((playerNames[0] + "'s turn"));
            }

            return true;
        }else{
            return false;
        }
    }

    public boolean checkForWinner() {

        int boardFilled = 0; //if board if filled up for a tie i.e no winner
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled += 1; //increment boardFilled value by 1 each time it finds a non zero value
                }
            }
        }


            boolean isWinner = false;

            //horizontal check
            for (int r = 0; r < 3; r++) {
                //r = whatever postn row is in and hardcode postn for col and also checks if the gameboard has no initial Os i.e user hasn't played yet
                if (
                        gameBoard[r][0] == gameBoard[r][1]
                                && gameBoard[r][0] == gameBoard[r][2]
                                && gameBoard[r][0] != 0
                ) {
                    winType = new int[] {r,0,1}; //winType == 1
                    isWinner = true;
                }
            }

            //vertical check
            for (int c = 0; c < 3; c++) {
                //r = whatever postn col is in and hardcode postn for row and also checks if the gameboard has no initial Os i.e user hasn't played yet
                if (
                        gameBoard[0][c] == gameBoard[1][c]
                                && gameBoard[2][c] == gameBoard[0][c]
                                && gameBoard[0][c] != 0
                ) {
                    winType = new int[] {0,c,2}; //winType == 2
                    isWinner = true;
                }
            }

            //negative (\) diagonal check
            if (
                    gameBoard[0][0] == gameBoard[1][1]
                            && gameBoard[0][0] == gameBoard[2][2]
                            && gameBoard[0][0] != 0
            ) {
                winType = new int[] {0,2,3}; //winType == 3
                isWinner = true;
            }

            //positive (/) diagonal check
            if (
                    gameBoard[2][0] == gameBoard[1][1]
                            && gameBoard[2][0] == gameBoard[0][2]
                            && gameBoard[2][0] != 0
            ) {
                winType = new int[] {2,2,4}; //winType == 4
                isWinner = true;
            }


            if (isWinner) {
                //set our two btns to visible if game ends with winner
                playAgainBTN.setVisibility(View.VISIBLE);
                homeBTN.setVisibility(View.VISIBLE);

                //who won?
                playerTurn.setText((playerNames[player - 1] + " Has Won!"));
                return true;
            } else if (boardFilled == 9) {
                playAgainBTN.setVisibility(View.VISIBLE);
                homeBTN.setVisibility(View.VISIBLE);
                playerTurn.setText("Tied!");
                return true;
            } else {
                return false;
            }
    }


    public void resetGame(){
        //resets everything
        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                gameBoard[r][c]=0;
            }
        }
        player = 1;
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0] + " Starts Again"));
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
