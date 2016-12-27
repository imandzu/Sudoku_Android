package com.example.imansour.sudoku;

/**
 * Created by ISMAIL on 27/12/2016.
 */

import android.content.Context;
import android.view.View;

public class BaseSudokuCell extends View{


    private int value;
    private boolean modifiable = true;

    public BaseSudokuCell(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setNotModifiable(){
        modifiable = false;
    }

    public void setInitValue(int value){
        this.value = value;
        invalidate();
    }

    public void setValue( int value ){
        if( modifiable ){
            this.value = value;
        }

        invalidate();
    }

    public int getValue(){
        return value;
    }
}

