package com.sudoku;

import android.app.Activity;
import android.os.Bundle;

import com.sudoku.R;


public class Sudoku extends Activity {


	

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);



        MoteurJeu.getInstance().createGrid(this);

    }

    private void printSudoku(int Sudoku[][]) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(Sudoku[x][y] + "|");
            }
            System.out.println();
        }
    }
}