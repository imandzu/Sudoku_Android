package com.sudoku;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class BoutonsView extends GridView {


    public BoutonsView( Context context , AttributeSet attrs ){
        super(context , attrs);

        AdaptateurBouton gridViewAdapter = new AdaptateurBouton(context);

        setAdapter(gridViewAdapter);
    }

    class AdaptateurBouton extends BaseAdapter {

        private Context context;

        public AdaptateurBouton(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            if( v == null ){
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                v = inflater.inflate(R.layout.bouton, parent , false);

                NumBouton btn;
                btn = (NumBouton)v;
                btn.setTextSize(10);
                btn.setId(position);

                if( position != 9 ){
                    btn.setText(String.valueOf(position + 1));
                    btn.setNumber(position + 1);
                }else{
                    btn.setText("SUP");
                    btn.setNumber(0);
                }
                return btn;
            }

            return v;
        }

    }
}

