package com.example.imansour.sudoku;

import android.content.Context;
/**
 * Created by ISMAIL on 27/12/2016.
 */
public class GameEngine {
    private static GameEngine instance;

    private GameGrid grid = null;

    private int selectedPosX = -1, selectedPosY = -1;

    private GameEngine(){}

    public static GameEngine getInstance(){
        if( instance == null ){
            instance = new GameEngine();
        }
        return instance;
    }

    public void createGrid( Context context ){
        int[][] Sudoku = Generateur.getInstance().generGrille();
        Sudoku = Generateur.getInstance().removeElements(Sudoku);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
    }

    public GameGrid getGrid(){
        return grid;
    }

    public void setSelectedPosition( int x , int y ){
        selectedPosX = x;
        selectedPosY = y;
    }


}

