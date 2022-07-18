import java.util.Scanner;  

public class CRUD {
    
    private Scanner scanner = new Scanner(System.in);
    private Reader read = new Reader();
    private int maxOptions = 5;
    private int[] playerPositions = {0,1};

    public void bootPlayers(Player[] players) {
        players[0] = new Player();
        players[1] = new Player();

        players[0].name = "Ale";
        players[0].wins = 0;
        players[0].losses = 0;
        players[0].gamesPlayed = 0;

        players[1].name = "Player 2";
        players[1].wins = 0;
        players[1].losses = 0;
        players[1].gamesPlayed = 0;
    }
    
    public void printMenu(Player[] players){

        int option = 0;
        String intro = "Choose an option from 1 to " + maxOptions; 
        do {
            menuOptions();
            option = read.getOption(intro, maxOptions);
            executeOption(option, players);            
        } while (option != maxOptions);
                
    }

    public int[] getPlayerPositions(){
        return playerPositions;
    }



    private void selectPlayers(Player[] player) {
        printPlayers(player);   
        int maxPlayers = howManyPlayers(player) - 1;
        int[] positions = {0, 1};
        String player1Select = "Select Player 1: ";  
        String player2Select = "Select Player 2: ";
        int p1Position, p2Position = 0; 
        
        p1Position = read.getOption(player1Select, maxPlayers) - 1;
        positions[0] = p1Position ;
          
        p2Position = read.getOption(player2Select, maxPlayers) - 1;
        positions[1] = p2Position ;
            
        System.out.println("Players selected: "); 
        System.out.println(player[p1Position].name); 
        System.out.println(player[p2Position].name); 
        
        playerPositions[0] = p1Position;
        playerPositions[1] = p2Position;

       // return positions;
    }

    public void printPlayers(Player[] player){ 
        System.out.println("Players: ");  
        for (int i = 0; i < player.length; i++){
            if (player[i] != null)System.out.println((i+1)+") "+ player[i].name);  
        }     
                
    }

    private void createPlayer(Player[] players){
        
        System.out.println("Player Creation");
        String newName = "";
        String askNewName = "Enter new player's name: ";
        int newPlayerPosition = howManyPlayers(players)-1;

       // newName = read.getOptionString(askNewName);
       
       System.out.println(askNewName);
       newName = scanner.nextLine();
       try{
        System.out.println("Creating Player");
        players[newPlayerPosition] = new Player();
        players[newPlayerPosition].name = newName;
        players[newPlayerPosition].wins = 0;
        players[newPlayerPosition].losses = 0;
        players[newPlayerPosition].gamesPlayed = 0;
        System.out.println("Player "+players[newPlayerPosition].name + " created. ");
        
       } catch (Exception e){
        System.out.println("Players are full");
       }
                
    }
    
    private void editPlayer(Player player){
        String newName = "";
        String askNewName = "Enter " + player.name +"'s new name: ";

       System.out.println(askNewName);
       newName = scanner.nextLine();
       player.name = newName;     
                
    }

    public int howManyPlayers(Player[] player){
        int activePlayers = 0;
        for (int i = 0; i < player.length; i++){
            if (player[i] != null){
               // System.out.println((i+1)+") "+ player[i].name);
                activePlayers = i+2;
        }  
    }
    return activePlayers;

    }

    private void menuOptions() {
        
        System.out.println("*************CRUD*************");
        System.out.println("****Players Administration****");
        System.out.println("1) Show Players");
        System.out.println("2) Select Players");
        System.out.println("3) Edit Player");
        System.out.println("4) Create Player");
        System.out.println("5) Exit");
    
    }
    private void editOptions(Player[] player) {
        String question = "Who do you wish to edit?";
        int option = 0;
        int activePlayers = howManyPlayers(player);

        do {
            System.out.println("*************EDIT PLAYER*************");
            printPlayers(player);
            System.out.println(activePlayers + ") Exit");           
            option = read.getOption(question, maxOptions);
            if (option < activePlayers) editPlayer(player[option-1]);  

        } while (option != activePlayers);       
    }
    
    private void executeOption(int option, Player[] players) {
        switch (option) {
            case 1:
                printPlayers(players);
                break;
            case 2:
                selectPlayers(players);            
                break;
            case 3:
                editOptions(players);            
                break;                
            case 4:
                createPlayer(players);
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
