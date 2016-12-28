package com.sudoku;

import android.content.Context;
import android.view.View;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class BaseCellule extends View {


    private int value;
    private boolean modifiable = true;

    public BaseCellule(Context context) {
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