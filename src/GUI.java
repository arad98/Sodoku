import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.*;

/*
goal: show current sudoku board

use a jpanel for each block total of 9 jpanel blocks each with 9 numbers
*/
public class GUI extends board{
    private JPanel panel;
    private JButton[][] buttons;
    private final int SIZE = 9;
    private GridLayout testLayout;
    private board SuBor;
    
    
    JFrame f;
    GUI() {
        SuBor = new board();
        f=new JFrame();
        testLayout = new GridLayout(SIZE,SIZE);
        panel = new JPanel();
        panel.setLayout(testLayout);
        f.setSize(500,500);
        
        buttons = new JButton[SIZE][SIZE];
        createButtons();
    
        
        f.add(panel);
        f.setVisible(true);
    }

    public void createButtons()
    {
        for(int k = 0;k < SIZE; k++)
            for(int j = 0 ;j < SIZE; j++)
            {
                int spot = SuBor.getBoardSpot(k, j);
                String out = String.valueOf(spot);
                buttons[k][j] = new JButton(out); // here is where I can insert the sudoku board spots-
                panel.add(buttons[k][j]);
            }

    }



    public static void main(String args[]){
       
       new GUI();
     }



}
