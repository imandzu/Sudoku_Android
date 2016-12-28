package com.sudoku;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class MoteurGrille {
    private Cellule[][] Sudoku = new Cellule[9][9];

    private Context context;

    public MoteurGrille( Context context ){
        this.context = context;
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                Sudoku[x][y] = new Cellule(context);
            }
        }
    }

    public void setGrid( int[][] grid ){
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                Sudoku[x][y].setInitValue(grid[x][y]);
                if( grid[x][y] != 0 ){
                    Sudoku[x][y].setNotModifiable();
                }
            }
        }
    }

    public Cellule[][] getGrid(){
        return Sudoku;
    }

    public Cellule getItem(int x , int y ){
        return Sudoku[x][y];
    }

    public Cellule getItem( int position ){
        int x = position % 9;
        int y = position / 9;

        return Sudoku[x][y];
    }

    public void setItem( int x , int y , int number ){
        Sudoku[x][y].setValue(number);
    }

    public void verifierJeu(){
        int [][] sudGrid = new int[9][9];
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++ ){
                sudGrid[x][y] = getItem(x,y).getValue();
            }
        }

        if( Verificateur.getInstance().verifierSudoku(sudGrid)){
            Toast.makeText(context, "Vous avez Gagné.", Toast.LENGTH_LONG).show();
        }
    }


}

