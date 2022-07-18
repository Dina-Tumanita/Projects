/*
* Crear un algoritmo que calcule si dos números son divisibles. Para ello, se piden un primer número y un segundo número, entonces mostrar un cartel que diga “es divisible” si el segundo número es divisible al primero.
* 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex5{
   static BufferedReader cnsl = new BufferedReader(new InputStreamReader(System.in));
   static int number = 0, size = 2;
   static int[] numbers = {0, 0};

public static void main(String []args) {        //main 
   ask4number();
   printcartel(dividenumbers(numbers));
}


static void ask4number(){
   
   try{ 
    for (int i = 0; i < size; i++){
        System.out.println("Please enter a number: " );
        numbers[i] = Integer.parseInt(cnsl.readLine());
    }

   } 
   catch (Exception e){  
       System.out.println("Please enter a number... " ); //requests digits
   }
}

static boolean dividenumbers(int[] arraynum){
   
   try{  
       number = arraynum[0] / arraynum[1];
       return true;
   } 
   catch (Exception e){  
       return false;
   }
}

static void printcartel(boolean checking){
   
   try{    
    if (checking) {
    System.out.println("-------------------------------------\n\n           ES DIVISIBLE\n\n-------------------------------------" ); //requests digits
}
    else {
        System.out.println("LOL" ); //requests digits
        
    }
   } 
   catch (Exception e){  
       
   }
}

}   