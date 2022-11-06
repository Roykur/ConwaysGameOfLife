package com.example.gameoflifeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.Random;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private Canvas canv;

    private GraphicsContext gc;

        //NEED TO CHANGE THAT!
    final int MAT_SIZE = 10; //mat is always NxN i.e a square
    final int SQUARE_SIZE = 33;
    final Color NO_LIFE = Color.DARKGRAY;
    final Color LIFE =  Color.WHEAT;

    public void initialize(){
        gc = canv.getGraphicsContext2D();
    }

    GameOfLife game = new GameOfLife();

    @FXML
    void onStartButtonClick(ActionEvent event) {

        //main game loop
        int row_count = 0;
        for (int i = 0; i < MAT_SIZE; i++) {
            int col_count = 0;
            for (int j = 0; j < MAT_SIZE; j++) {
                gc.setFill(game.get_mat()[row_count][col_count] ? LIFE : NO_LIFE);
                // add 1 to the coordinates of the start point and reduce 1 from the width and height to create a frame for each swaure
                gc.fillRect((row_count * SQUARE_SIZE )+1, (col_count * SQUARE_SIZE)+1, SQUARE_SIZE-1, SQUARE_SIZE-1);
                col_count++;
            }
            row_count++;
        }
        //create next gen
        game.next_gen();

    }



}
