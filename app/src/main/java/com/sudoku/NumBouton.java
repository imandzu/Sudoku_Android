package com.sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class NumBouton extends Button implements View.OnClickListener {

    private int number;

    public NumBouton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MoteurJeu.getInstance().setNumber(number);
    }

    public void setNumber(int number){
        this.number = number;
    }
}

