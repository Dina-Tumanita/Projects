
/*
* Diseñar un algoritmo que, dados tres números enteros, calcule e imprima el promedio entre ellos.
* 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex2{
   static BufferedReader cnsl = new BufferedReader(new InputStreamReader(System.in));
   static double number = 0, size = 3;
   static double[] numbers = {0, 0, 0};
   
public static void main(String []args) {        //main 
   ask4number();
   averagenumber();
   printnumber();
}

static void ask4number(){
   
   try{  
    for (int i = 0; i < size; i++){
        System.out.println("Please enter a number: " );
        numbers[i] = Double.parseDouble(cnsl.readLine());
    }

   } 
   catch (Exception e){  
       System.out.println("Please enter a number... " ); //requests digits
   }
}

static void averagenumber(){
   
   try{  
    for (int i = 0; i < 3; i++){
        number += numbers[i];
    }
    number = number / size;
   } 
   catch (Exception e){  
       
   }
}

static void printnumber(){
   
   try{    
       System.out.println("Average number is: " + number ); //requests digits
   } 
   catch (Exception e){  
       
   }
}

}