package com.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class TicTacToeBoard extends View {

    private final int board_color;
    private final int X_color;
    private final int O_color;
    private final int winning_line_color;

    //
    private final Paint paintObject = new Paint();

    private int cellSize = getWidth()/3; //can be overridden with the onMeasure method .'.'. down below;

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.TicTacToeBoard,0,0);
        try {
            board_color = a.getInteger(R.styleable.TicTacToeBoard_board_color,0);
            X_color = a.getInteger(R.styleable.TicTacToeBoard_X_color,0);
            O_color = a.getInteger(R.styleable.TicTacToeBoard_O_color,0);
            winning_line_color = a.getInteger(R.styleable.TicTacToeBoard_winning_line_color,0);
        }finally {
            a.recycle();
        }
    }

    @Override
    protected  void onMeasure (int width, int height) {
        super.onMeasure(width,height);

        //get square shape, hence use min in maths method
        int dimension = Math.min(getMeasuredHeight(), getMeasuredWidth());

        //cellSize for fitting an X or O gotten by dividing the dimension into 3 parts
        cellSize = dimension/3;

        //set height for min to all the sides of square
        setMeasuredDimension(dimension,dimension);
    }

    @Override
    //canvas - area of our view;
    protected  void  onDraw (Canvas canvas){
        paintObject.setStyle(Paint.Style.STROKE);
        paintObject.setAntiAlias(true);

        //a method thar will  actually draw the board
        drawGameBoard(canvas);

        //a method to draw the X
        drawX(canvas, 1,1);

        //a method to draw the O
        drawO(canvas, 2,2);
    }

    private void drawGameBoard(Canvas canvas){
        paintObject.setColor(board_color);
        paintObject.setStrokeWidth(14);

        //columns
        for (int c=1;c<3;c++){
            //(5 args) starting postn for x and y, end postn for x and y ,the paint obj
            canvas.drawLine(cellSize*c, 0, cellSize*c, canvas.getWidth(), paintObject);
        }
        //rows
        for (int r=1;r<3;r++){
            canvas.drawLine(0, cellSize*r, canvas.getWidth(), cellSize*r, paintObject);
        }
    }
    private void drawX(Canvas canvas, int row,int col){
        paintObject.setColor(X_color);

        //the float is for reduction with the  .2
        canvas.drawLine(
                (float)((col+1)*cellSize-cellSize*0.2),
                (float)(row*cellSize+cellSize*0.2),
                (float)(col*cellSize+cellSize*0.2),
                (float)((row+1)*cellSize-cellSize*0.2),
                paintObject
                );
        canvas.drawLine(
                (float)(col*cellSize+cellSize*0.2),
                (float)(row*cellSize+cellSize*0.2),
                (float)((col+1)*cellSize-cellSize*0.2),
                (float)((row+1)*cellSize-cellSize*0.2),
                paintObject
                );
    }
    private void drawO(Canvas canvas, int row,int col){
        paintObject.setColor(O_color);

        canvas.drawOval(
                (float)( col*cellSize+cellSize*0.2),
                (float) (row*cellSize+cellSize*0.2),
                (float) (col*cellSize+cellSize-cellSize*0.2),
                (float) (row*cellSize+cellSize-cellSize*0.2),
                paintObject
                );
    }
}


//NB: the xmlns:custom="http://schemas.android.com/apk/res-auto" in gamePage allows us to use custom attributes for our tictactoe game
