package com.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class TicTacToeBoard extends View {

    private final int board_color;
    private final int X_color;
    private final int O_color;
    private final int winning_line_color;

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

        //set height for min to all the sides of square
        setMeasuredDimension(dimension,dimension);
    }
}
