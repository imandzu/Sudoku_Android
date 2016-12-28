package com.sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class SudokuView extends GridView{

    private final Context context;

    public SudokuView(final Context context , AttributeSet attrs) {
        super(context,attrs);

        this.context = context;

        Adaptateur gridViewAdapter = new Adaptateur(context);

        setAdapter(gridViewAdapter);

        setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;

                MoteurJeu.getInstance().setSelectedPosition(x, y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class Adaptateur extends BaseAdapter {

        private Context context;

        public Adaptateur(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return MoteurJeu.getInstance().getGrid().getItem(position);
        }
    }
}
