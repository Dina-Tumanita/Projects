import java.util.Scanner;  

public class Reader {

    private Scanner scanner = new Scanner(System.in);
    
    public int getOption(String msg, int limit){
        int res = 0;
        System.out.println(msg);
        while (true){
            try { 
                res = scanner.nextInt(); 
                if (res >= 1 && res <= limit){
                    return res;
                } else System.out.println("Not a valid option");  
            } catch (Exception e) {
                System.out.println("Oopsieeee");               
            }
        }
        }
    
        public String getOptionString(String msg){
            //String res ;
            
            System.out.println(msg);
            msg = scanner.nextLine(); 
            return msg;
            // while (true){
            //     try { 
                    
            //     } catch (Exception e) {
            //         System.out.println("You made an oopsie");               
            //     }
            // }
            }

}
