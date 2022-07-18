/*
Program that plays tic tac toe on console 
JAVA

*/

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTacToe{

static String[][] totito = {{"   ", "|", "   ", "|", "   "},                                      // el totito visual
                            {"---", "-", "---", "-", "---"}, 
                            {"   ", "|", "   ", "|", "   "}, 
                            {"---", "-", "---", "-", "---"},
                            {"   ", "|", "   ", "|", "   "},  };

static int[][] pintado = {{1, 1, 1},                                             // 0,0 0,1 0,2 // el totito visual pintado para la eleccion del bot
                          {1, 1, 1},                                                   // 1,0 1,1 1,2  
                          {1, 1, 1} };

static int x;
static int y;
static int rand1;
static int rand2;
static int gaming = 1;

//TicTacToe check = new TicTacToe();

public static void main(String []args) {
    
    System.out.println("This is Tic Tac Toe");
    try{
    do {
      printing();
      checkall();
      if (gaming == 1){
      botplayer();
      totito[2*rand1][2*rand2] = " O ";   //assigns chosen position O
    } else return;
    } while (gaming == 1); //do ends
    System.out.println("Game Finished");
  } //try
    catch(Exception e){
      System.out.println("Please enter a digit from 0 to 2 please. ");
    }
  
 
   // 
  
}


static void botplayer() { //bot player move
  rand1 = (int) Math.floor(Math.random()*(2));
  rand2 = (int) Math.floor(Math.random()*(2));

  while (!checker(rand1,rand2)){
    rand1++;
    rand2++;
    if (rand1 == 3){
      rand1 = 0;
    }
    if (rand2 == 3){
      rand2 = 0;
    }
    
  //  rand1 = (int) Math.floor(Math.random()*(2));
  //  rand2 = (int) Math.floor(Math.random()*(2));
    
  } //while
  
}  

static public boolean checker(int xc, int yc) { //checks to see if spot is taken

  if (totito[2*xc][2*yc] == " X " || totito[2*xc][2*yc] == " O "  ){
    return false;
  }
  else return true;   //the box is available
}  

static void checkall() { //checks to see if spot is taken
  int sum = 0;
  for (int i = 0; i<=2; i++){
    for (int j = 0; j<=2; j++){
      if (!checker(i,j)) sum++;    //checks if all boxes are checked
    }
  }
  if (sum == 9) {
    gaming = 0;
    return; 
  } else sum = 0;
} 

static void printing() throws IOException {
  BufferedReader cnsl = new BufferedReader(new InputStreamReader(System.in));

  for (int i = 0; i<=4; i++){
    for (int j = 0; j<=4; j++){
      System.out.printf(totito[i][j]);    //prints totito matrix
    }
    System.out.println("");   //MAKES A LINE
  }
  x = 5;  //activates question
  y = 5;
try{                   //checks for faulty values like strings
  while  (x<0 || x>2) {
      System.out.println("Enter your row # (0-2):  ");
      x = Integer.parseInt(cnsl.readLine());
    } 
    while  (y<0 || y>2) {
      System.out.println("Enter your column # (0-2):  ");
      y = Integer.parseInt(cnsl.readLine());
    } 
    
    System.out.println("You selected: " + x + "," + y);
    if (checker(x,y)){
      totito[2*x][2*y] = " X ";   //assigns chosen position X
    } else {
      System.out.println("Taken, try again \n");
      return;
    }

    } catch (Exception e){    //requests digits
      System.out.println("Please enter a digit from 0 to 2. ");
    }
  }

}