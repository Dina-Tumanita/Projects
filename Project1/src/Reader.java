import java.util.Scanner;  

public class Reader {

    private Scanner scanner = new Scanner(System.in);
    
    public int getInt(String msg, int limit){
        int res = 0;
        System.out.println(msg);
        while (true){
            try { 
                res = scanner.nextInt(); 
                if (res >= 1 && res <= limit){
                    return res;
                }
            } catch (Exception e) {
                System.out.println("You made an oopsie");               
            }
        }
        }
    
        public String getString(String msg, int limit){
            String res = "";
            System.out.println(msg);
            while (true){
                try { 
                    res = scanner.nextLine(); 
                    return res;
                    
                } catch (Exception e) {
                    System.out.println("You made an oopsie");               
                }
            }
            }

}
