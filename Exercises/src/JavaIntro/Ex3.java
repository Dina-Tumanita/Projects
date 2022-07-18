
/*
* Diseñar un algoritmo que imprima el área y el perímetro de un rectángulo ingresando su base y altura.
* 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex3{
   static BufferedReader cnsl = new BufferedReader(new InputStreamReader(System.in));
   static double number, size = 2;
   static double[] numbers = {0, 0};

public static void main(String []args) {        //main 
   ask4number();
   calculatearea(numbers);
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

static void calculatearea(double[] arraynum){
   
   try{  
       number = arraynum[0] * arraynum[1];
   } 
   catch (Exception e){  
       
   }
}

static void printnumber(){
   
   try{    
       System.out.println("Area is : " + number ); //requests digits
   } 
   catch (Exception e){  
       
   }
}

}   