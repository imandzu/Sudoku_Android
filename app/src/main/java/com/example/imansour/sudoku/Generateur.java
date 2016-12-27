package com.example.imansour.sudoku;


import java.util.ArrayList;
import java.util.Random;
/**
 * Created by ISMAIL on 27/12/2016.
 */
public class Generateur {

    private static Generateur instance;

    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();

    private Random rand = new Random();

    private Generateur(){}

    public static Generateur getInstance(){
        if( instance == null ){
            instance = new Generateur();
        }
        return instance;
    }


    // fonction permet de générer la grille en générale
    public int[][] generGrille(){
        int[][] Sudoku = new int[9][9];

        int posActuel = 0;


        while( posActuel < 81 ){
            if( posActuel == 0 ){
                effacerGrille(Sudoku);
            }

            if( Available.get(posActuel).size() != 0 ){
                int i = rand.nextInt(Available.get(posActuel).size());
                int number = Available.get(posActuel).get(i);

                if( !verifierConflit(Sudoku, posActuel , number)){
                    int xPos = posActuel % 9;
                    int yPos = posActuel / 9;

                    Sudoku[xPos][yPos] = number;

                    Available.get(posActuel).remove(i);

                    posActuel++;
                }else{
                    Available.get(posActuel).remove(i);
                }

            }else{
                for( int i = 1 ; i <= 9 ; i++ ){
                    Available.get(posActuel).add(i);
                }
                posActuel--;
            }
        }


        return Sudoku;
    }

    public int[][] removeElements( int[][] Sudoku ){
        int i = 0;

        while( i < 3 ){
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);

            if( Sudoku[x][y] != 0 ){
                Sudoku[x][y] = 0;
                i++;
            }
        }
        return Sudoku;

    }
    // fonction permet de vider la grille en générale
    private void effacerGrille(int [][] Sudoku){
        Available.clear();

        for( int y =  0; y < 9 ; y++ ){
            for( int x = 0 ; x < 9 ; x++ ){
                Sudoku[x][y] = -1;
            }
        }

        for( int x = 0 ; x < 81 ; x++ ){
            Available.add(new ArrayList<Integer>());
            for( int i = 1 ; i <= 9 ; i++){
                Available.get(x).add(i);
            }
        }
    }

    // fonction permet de verifier l'existant des conflits
    private boolean verifierConflit( int[][] Sudoku , int posActuel , final int number){
        int xPos = posActuel % 9;
        int yPos = posActuel / 9;

        if( verifierHorizontalConflit(Sudoku, xPos, yPos, number) || verifierVerticalConflit(Sudoku, xPos, yPos, number) || verifierRegionConflit(Sudoku, xPos, yPos, number) ){
            return true;
        }

        return false;
    }

    /**
     * Return true if there is a conflict
     * @param Sudoku
     * @param xPos
     * @param yPos
     * @param number
     * @return
     */

    // fonction permet de verifier l'existant des conflits au niveau des lignes
    private boolean verifierHorizontalConflit( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        for( int x = xPos - 1; x >= 0 ; x-- ){
            if( number == Sudoku[x][yPos]){
                return true;
            }
        }

        return false;
    }

    // fonction permet de verifier l'existant des conflits au niveau des colonnes
    private boolean verifierVerticalConflit( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        for( int y = yPos - 1; y >= 0 ; y-- ){
            if( number == Sudoku[xPos][y] ){
                return true;
            }
        }

        return false;
    }

    // fonction permet de verifier l'existant des conflits au niveau des groupes
    private boolean verifierRegionConflit( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        int xRegion = xPos / 3;
        int yRegion = yPos / 3;

        for( int x = xRegion * 3 ; x < xRegion * 3 + 3 ; x++ ){
            for( int y = yRegion * 3 ; y < yRegion * 3 + 3 ; y++ ){
                if( ( x != xPos || y != yPos ) && number == Sudoku[x][y] ){
                    return true;
                }
            }
        }

        return false;
    }
}
