package com.sudoku;

/**
 * Created by ISMAIL on 28/12/2016.
 */
public class Verificateur {

    private static Verificateur instance;

    private Verificateur(){}

    public static Verificateur getInstance(){
        if( instance == null ){
            instance = new Verificateur();
        }
        return instance;
    }

    public boolean verifierSudoku( int[][] Sudoku){
        return (verifierHorizontal(Sudoku) || verifierVertical(Sudoku) || verifierRegions(Sudoku));
    }

    private boolean verifierHorizontal(int[][] Sudoku) {
        for( int y = 0 ; y < 9 ; y++ ){
            for( int xPos = 0 ; xPos < 9 ; xPos++ ){

                if( Sudoku[xPos][y] == 0 ){
                    return false;
                }
                for( int x = xPos + 1 ; x < 9 ; x++ ){
                    if( Sudoku[xPos][y] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean verifierVertical(int[][] Sudoku) {
        for( int x = 0 ; x < 9 ; x++ ){
            for( int yPos = 0 ; yPos < 9 ; yPos++ ){

                if( Sudoku[x][yPos] == 0 ){
                    return false;
                }
                for( int y = yPos + 1 ; y < 9 ; y++ ){
                    if( Sudoku[x][yPos] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean verifierRegions(int[][] Sudoku) {
        for( int xRegion = 0; xRegion < 3; xRegion++ ){
            for( int yRegion = 0; yRegion < 3 ; yRegion++ ){
                if( !verifierRegion(Sudoku, xRegion, yRegion) ){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verifierRegion(int[][] Sudoku , int xRegion , int yRegion){
        for( int xPos = xRegion * 3; xPos < xRegion * 3 + 3 ; xPos++ ){
            for( int yPos = yRegion * 3 ; yPos < yRegion * 3 + 3 ; yPos++ ){
                for( int x = xPos ; x < xRegion * 3 + 3 ; x++ ){
                    for( int y = yPos ; y < yRegion * 3 + 3 ; y++ ){
                        if( (( x != xPos || y != yPos) && Sudoku[xPos][yPos] == Sudoku[x][y] ) || Sudoku[x][y] == 0 ){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


