

public class Menu {
    private Reader read = new Reader();
    private TicTacToe tictactoe = new TicTacToe();
    private HangMan hangman = new HangMan();
    private CRUD crud = new CRUD();
    private GameStatistics gameStats = new GameStatistics();
    private PlayerStatistics playerStats = new PlayerStatistics();
    private Player players[] = new Player[10];

    //private int currentPlayers[] = new int[2];

    private final int maxOptions = 6;
    
    public void play(){
        crud.bootPlayers(players);
        printMenu(); 

    }

    private void printMenu(){ 
        int option = 0;
        String intro = "Choose an option from 1 to " + maxOptions; 
        do {
            menuOptions();
            option = read.getInt(intro, maxOptions);
            executeOption(option);            
        } while (option != maxOptions);

    }

    private void playTicTacToe(Player player1, Player player2){
        tictactoe.play(player1, player2);
    }

    private void playHangMan(Player player1, Player player2){
        hangman.play(player1, player2);
    }

    private void showPlayerStats(){
        playerStats.showStats();
    }

    private void showGameStats(){
        gameStats.showStats();
    }

    private void showCRUD(){
        crud.printMenu(players);
    }

    
    private void executeOption(int option) {
        switch (option) {
            case 1:
                playTicTacToe(players[0], players[1]);
                break;
            case 2:
                playHangMan(players[0], players[1]);
                break;
            case 3:
                showCRUD();
                break;
            case 4:
                showPlayerStats();
                break;
            case 5:
                showGameStats();
                break;
            case 6:
                System.out.println("Good Bye!");
                break;
            default:
                System.out.println("Not an option");
                break;
        }
    }

    private void menuOptions() {
        
        System.out.println("***********WELCOME***********");
        System.out.println("1) Play Tic Tac Toe");
        System.out.println("2) Play Hangman");
        System.out.println("3) CRUD (Player Settings) ");
        System.out.println("4) Player Statistics");
        System.out.println("5) Game Statistics");
        System.out.println("6) Exit");
    
    }

}
