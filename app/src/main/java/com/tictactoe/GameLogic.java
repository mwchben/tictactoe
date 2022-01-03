package com.tictactoe;

public class GameLogic {
    private int [][] gameBoard;

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
            return true;
        }else{
            return false;
        }
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
}
