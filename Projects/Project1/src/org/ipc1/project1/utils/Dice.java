package org.ipc1.project1.utils; 

import java.util.Random;

public class Dice {
    Random random = new Random();
    private int thrown = 0;

    public int isThrown(){
        int sides = 6;
        thrown = random.nextInt(sides) + 1;
        printThrow();  
        return thrown;        
    }

    private void printThrow(){
        System.out.println("***Dice is thrown***");

        //System.out.println("Amount is: "+ thrown);
    }


}
