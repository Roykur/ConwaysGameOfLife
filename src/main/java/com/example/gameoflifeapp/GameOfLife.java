package com.example.gameoflifeapp;

import java.util.Random;

public class GameOfLife{

    protected final int MAT_SIZE = 10; //mat is always NxN i.e a square

    boolean[][] mat;
    boolean is_life_everywhere;

    //empty constructor
    public GameOfLife(){
        this.mat = randomize_mat(new boolean[MAT_SIZE][MAT_SIZE]);
        this.is_life_everywhere = false;
    }

    //get method
    public boolean[][] get_mat(){
        return copy_mat(this.mat);
    }

    public boolean get_is_life_everywhere(){
        return is_life_everywhere;
    }

    // gets a boolean matrix and return a copy of it
    private boolean[][] copy_mat(boolean[][] src_mat){
        boolean[][] dest_mat = new boolean[MAT_SIZE][MAT_SIZE];
        for(int i=0; i<src_mat.length; i++){
            for(int j=0; j<src_mat[0].length; j++){
                dest_mat[i][j] = src_mat[i][j];
            }
        }
        return dest_mat;

    }

    private boolean[][] randomize_mat(boolean[][] mat){
        Random r = new Random();
        for(int i=0; i<MAT_SIZE; i++){
            for(int j=0; j<MAT_SIZE; j++){
                mat[i][j] = r.nextBoolean();
            }
        }
        return mat;
    }


    public void next_gen(){
        boolean[][] next_gen_mat = new boolean[MAT_SIZE][MAT_SIZE];
        for(int i=0; i<MAT_SIZE; i++){
            for(int j=0; j<MAT_SIZE; j++){
                int living_neighbours = get_living_neighbours(i, j);
                if (living_neighbours==3)
                    next_gen_mat[i][j] = true;
                else next_gen_mat[i][j] = living_neighbours == 2 && mat[i][j];

            }
        }
        this.mat = copy_mat(next_gen_mat);
    }


    //checks one cell and returns ture if it is alive in next gen and false if not
    private int get_living_neighbours(int row, int col){
        int living_neighbours_count = 0;
        for(int i=row-1; i<=row+1; i++){
            for(int j=col-1; j<=col+1; j++){
                if(((0<=i && i<MAT_SIZE) && (0<=j && j<MAT_SIZE)) && (i!=row || j!=col))
                        if (this.mat[i][j])
                            living_neighbours_count++;
            }
        }
        return living_neighbours_count;
    }


}
