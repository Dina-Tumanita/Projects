
import java.util.Scanner;

public class Terminal {
    private Scanner scanner;

    public Terminal(){
        scanner = new Scanner(System.in);
    }



    public void startGame(){
        System.out.println("---------------------------------------------");
        System.out.println("-- Welcome to The Lord of the Rings game!! --");
        System.out.println("---------------------------------------------");
    } 

    public void printMenu(String armyCreation) {
        if (armyCreation == "Heroes"){
            System.out.println("Choose a hero: ");
            System.out.println("1) Human");
            System.out.println("2) Elf");
            System.out.println("3) Hobbit");
    }
    if (armyCreation == "Beasts"){
        System.out.println("Choose a beast: ");
        System.out.println("1) Orc");
        System.out.println("2) Goblin");
}
    }

    public int getOption(String msg, int limit){
        int res = 0;
            System.out.println(msg);
            try { 
                System.out.println("A number from 1-"+limit+", please");
                res = scanner.nextInt(); 
                return res;
            } catch (Exception e) {
                System.out.println("A number from 1-"+limit+", please");
            }
            return res;
        }

    

}
