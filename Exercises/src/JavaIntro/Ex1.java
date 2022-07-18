
/*
 * Diseñar un algoritmo que pida un número por teclado y luego imprima el número siguiente al ingresado.
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex1{
    static BufferedReader cnsl = new BufferedReader(new InputStreamReader(System.in));
    static int number;
    
public static void main(String []args) {        //main 
    ask4number();
    nextnumber();
    printnumber();
}

static void ask4number(){
    
    try{  
        System.out.println("Please enter a number. " );
        number = Integer.parseInt(cnsl.readLine());
    } 
    catch (Exception e){  
        System.out.println("Please enter a number. " ); //requests digits
    }
}

static void nextnumber(){
    
    try{  
        number++;
    } 
    catch (Exception e){  
        
    }
}

static void printnumber(){
    
    try{    
        System.out.println("Next number is: " + number ); //requests digits
    } 
    catch (Exception e){  
        
    }
}

}