import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dice {
    Random random = new Random();
    int value;
    int thrown = 0;

    public int isThrown(int times, int max){
        thrown = 0;
        value = 0;
        for (int i = 0; i < times; i++){
            thrown = random.nextInt(max) + 1;
            printThrow();
            if (thrown > value){
                value = thrown;
            }
        } //for
        printFinal();
        return value;
        
    }

    private void printThrow(){
        System.out.println("***Dice is thrown***");
        System.out.println("Amount is: "+ thrown);
    }

    private void printFinal(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Value chosen: "+ value+ "\n");
    }

}
