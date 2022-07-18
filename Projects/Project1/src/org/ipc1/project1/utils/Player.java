package org.ipc1.project1.utils; 

import java.util.Scanner;  

public class Player {

    private Reader read = new Reader();
    private Scanner scanner = new Scanner(System.in);

    public String name;
    public int wins;
    public int losses;
    public int wonTTT;
    public int wonHM;
    public int lostTTT;
    public int lostHM;
    public int gamesPlayed;

    public int sendPlayInt(){
        int option;
        String ask = "Enter your play: ";
        option = read.getOption(ask, 4); 
        return option;
    }

    public String sendPlayString(){
        String option;
        String ask = "***************";
        
        System.out.println(ask);
        option = scanner.nextLine(); 
        return option;
    }

}

