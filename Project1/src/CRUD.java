

public class CRUD {
    private Reader read = new Reader();
    private int maxOptions = 5;
    private int maxEditOptions;

    public void bootPlayers(Player[] players) {
        players[0] = new Player();
        players[1] = new Player();

        players[0].name = "Player 1";
        players[1].name = "Player 2";
    }
    
    public void printMenu(Player[] players){

        int option = 0;
        String intro = "Choose an option from 1 to " + maxOptions; 
        do {
            menuOptions();
            option = read.getInt(intro, maxOptions);
            executeOption(option, players);            
        } while (option != maxOptions);
                
    }

    public int[] selectPlayers(int positionP1, int positionP2) {
        int[] positions = {0, 1};
        return positions;
    }

    public void printPlayers(Player[] player){ 
        System.out.println("Players: ");  
        for (int i = 0; i < player.length; i++){
            if (player[i] != null)System.out.println("Player "+(i+1)+": "+ player[i].name);  
        }     
                
    }

    public void createPlayer(Player[] players){
        
        System.out.println("Player Creation");
                
    }

    public void editMenu(Player[] players){
        int option = 0;
        maxEditOptions = players.length;
        String intro = "Choose an option from 1 to " + maxEditOptions; 
        System.out.println("Player Edit");
        do {
            editOptions(players);
            option = read.getInt(intro, maxOptions);
            editPlayer(players[option]);            
        } while (option != maxEditOptions);
                
    }

    public void editPlayer(Player player){
        
                
    }

    public void menuOptions() {
        
        System.out.println("*************CRUD*************");
        System.out.println("****Players Administration****");
        System.out.println("1) Show Players");
        System.out.println("2) Select Players");
        System.out.println("3) Edit Player");
        System.out.println("4) Create Player");
        System.out.println("5) Exit");
    
    }
    public void editOptions(Player[] player) {
        
        System.out.println("*************EDIT PLAYER*************");
        System.out.println("Who do you wish to edit?");
        for (int i = 0; i < player.length; i++){
            if (player[i] != null)System.out.println("Player "+(i+1)+": "+ player[i].name);  
        }  
        System.out.println(player.length + ") Exit");
        
    
    }
    
    private void executeOption(int option, Player[] players) {
        switch (option) {
            case 1:
                printPlayers(players);
                break;
            case 2:
            
                break;
            case 3:
            
                break;                
            case 4:
            
                break;            
            case 5:
                System.out.println("Exiting CRUD\n");            
                break;
            default:
                System.out.println("Not an option");
                break;
        }
    }



}
