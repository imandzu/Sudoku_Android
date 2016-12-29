package com.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by ISMAIL on 28/12/2016.
 */
public class Cellule extends BaseCellule {

    private Paint mPaint;

    public Cellule( Context context ){
        super(context);

        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(15);
        mPaint.setColor(Color.BLUE);


        Rect bounds = new Rect(1, 1, 100, 100);
        // fill
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(bounds, mPaint);

        // border
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(bounds, mPaint);



        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if( getValue() != 0 ){

            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width())/2, (getHeight() + bounds.height())/2	, mPaint);
        }
        //drawNumber(canvas);
        //drawLines(canvas);
    }

    private void drawNumber(Canvas canvas){
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(15);
        mPaint.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();



        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if( getValue() != 0 ){
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width())/2, (getHeight() + bounds.height())/2	, mPaint);
        }
    }

    private void drawLines(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.STROKE);


        canvas.drawRect(1, 1, getWidth(), getHeight(), mPaint);
    }
}
