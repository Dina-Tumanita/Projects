/*
* Diseñar un algoritmo que genere un número aleatorio del 0 al 200, lo muestre y luego calcule y muestre el mismo número aumentado en un 30%
* 
*/

import java.lang.Math;

public class Ex4{
   static double number; 

public static void main(String []args) {        //main 
   shownumber();
   plus30percent();
   printnumber();
}


static void shownumber(){

        number = Math.random()*200;
        System.out.println("Random number generated is : " + number);
        
}

static void plus30percent(){
    
      number *= 1.3;
      
}

static void printnumber(){
      
       System.out.println("Random number plus 30% is : " + number ); //requests digits
   
}

}   