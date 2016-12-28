package com.sudoku;

import android.content.Context;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class MoteurJeu {
    private static MoteurJeu instance;

    private MoteurGrille grid = null;

    private int selectedPosX = -1, selectedPosY = -1;

    private MoteurJeu(){}

    public static MoteurJeu getInstance(){
        if( instance == null ){
            instance = new MoteurJeu();
        }
        return instance;
    }

    public void createGrid( Context context ){
        int[][] Sudoku = Generateur.getInstance().generGrille();
        Sudoku = Generateur.getInstance().removeElements(Sudoku);
        grid = new MoteurGrille(context);
        grid.setGrid(Sudoku);
    }

    public MoteurGrille getGrid(){
        return grid;
    }

    public void setSelectedPosition( int x , int y ){
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber( int number ){
        if( selectedPosX != -1 && selectedPosY != -1 ){
            grid.setItem(selectedPosX,selectedPosY,number);
        }
        grid.verifierJeu();
    }
}
