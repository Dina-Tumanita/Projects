

public class Game {
    private Dice dice; 
    private Battlefield board; 
    private Terminal terminal;
    public final int armyMAX = 3;
    public int turn = 1;
    public String attacker;
    private int positionHero;
    private int positionBeast;
    private Soldier armyHeroes[]= new Hero[armyMAX];
    private Soldier armyBeasts[]= new Beast[armyMAX];

    public void play(){
        terminal = new Terminal();
        terminal.startGame();
        System.out.println("Each army will have "+ armyMAX +" soldiers");
        createArmy("Heroes");
        createArmy("Beasts");
        attacker = startTurn();
        System.out.println("First turn is for: "+ attacker);   
        
        while (teamAlive(armyHeroes) && teamAlive(armyBeasts) ){
            turnBattlefield();
        }
        if (teamAlive(armyHeroes)){
            System.out.println("****************Heroes Win!*********************");
        } else{
            System.out.println("****************Beasts Win!*********************");
        }

    }

    public void turnBattlefield(){
        board = new Battlefield();
        System.out.println("\n"+ attacker + " turn #"+ turn);
        positionHero = checkStatus(armyHeroes, positionHero);
        positionBeast = checkStatus(armyBeasts, positionBeast);
        if (attacker == "Heroes"){            
            board.attack(armyHeroes[positionHero], armyBeasts[positionBeast]);
            attacker = "Beasts";
        } else {
            board.attack(armyBeasts[positionBeast], armyHeroes[positionHero]);
            attacker = "Heroes";
        }
        positionHero++;
        positionBeast++;
        if (positionHero == armyMAX) positionHero = 0;
        if (positionBeast == armyMAX) positionBeast = 0;
        turn++;
       //
    }

    private boolean teamAlive(Soldier[] soldier){
        int membersAlive = 0;
        for (int i=0; i < armyMAX; i++){
            if (soldier[i].alive) membersAlive++;
        }

        return (membersAlive != 0) ? true : false;
                 
    }

    public int checkStatus(Soldier[] soldier, int position){
        while (!soldier[position].alive){
          position++;
          if (position == armyMAX) return 0;              
        }        
        return position;
    }


    public String startTurn(){
        dice = new Dice();
        int beastRoll;
        int heroRoll;
        String player;
        do{
            System.out.println("Heroes roll for 1st turn: ");
            heroRoll = dice.isThrown(1, 10);
            System.out.println("Beasts roll for 1st turn: ");
            beastRoll = dice.isThrown(1, 10);
            player = (heroRoll > beastRoll) ? "Heroes" : "Beasts";
    } while (heroRoll == beastRoll);
    return player;
    }



//String armyCreation = "Heroes";
    public void createArmy(String armyCreation){ 
        positionHero = 0;
        positionBeast = 0;

        int soldierPosition = 0;
        int amountTypes;
        if (armyCreation == "Heroes"){
            amountTypes = 3;
        } else amountTypes = 2;

        do {
            String choice = "Please enter your option of ";            
            terminal.printMenu(armyCreation);
            int option = terminal.getOption(choice, amountTypes);
            executeOption(option, soldierPosition, armyCreation);
            if (option <= amountTypes){
            soldierPosition++;
        }
        } while (soldierPosition < armyMAX);

    }
    
    private void executeOption(int choice, int position, String armyType) {
        switch (choice) {
            case 1:
                if (armyType == "Heroes") { 
                    armyHeroes[position] = new Human();
                    armyHeroes[position].dicethrows = 2;
                    armyHeroes[position].attackdmg = 100; 
                    armyHeroes[position].armor = 30;
                    armyHeroes[position].alive = true;
                    armyHeroes[position].spellAgainst = "NULL"; 
                    armyHeroes[position].type = "Human";
                    armyHeroes[position].lifepoints = 180;  
                }
                else if (armyType == "Beasts") {
                     armyBeasts[position] = new Orc();
                     armyBeasts[position].dicethrows = 1;
                     armyBeasts[position].attackdmg = 90; 
                     armyBeasts[position].armor = 50;
                     armyBeasts[position].alive = true;
                     armyBeasts[position].spellAgainst = "armorAll"; 
                     armyBeasts[position].type = "Orc";
                     armyBeasts[position].lifepoints = 300;  
            }
                break;

            case 2:
            if (armyType == "Heroes") { 
                armyHeroes[position] = new Elf();
                armyHeroes[position].dicethrows = 2;
                armyHeroes[position].attackdmg = 100; 
                armyHeroes[position].armor = 30;
                armyHeroes[position].alive = true;
                armyHeroes[position].spellAgainst = "orcFear"; 
                armyHeroes[position].type = "Elf";
                armyHeroes[position].lifepoints = 250;  
            }
            else if (armyType == "Beasts") {
                 armyBeasts[position] = new Goblin();
                 armyBeasts[position].dicethrows = 1;
                 armyBeasts[position].attackdmg = 90; 
                 armyBeasts[position].armor = 50;
                 armyBeasts[position].alive = true;
                 armyBeasts[position].spellAgainst = "NULL"; 
                 armyBeasts[position].type = "Goblin";
                 armyBeasts[position].lifepoints = 325;
        }
                break;

            case 3:
            if (armyType == "Heroes") { 
                armyHeroes[position] = new Hobbit();
                armyHeroes[position].dicethrows = 2;
                armyHeroes[position].attackdmg = 100; 
                armyHeroes[position].armor = 30;
                armyHeroes[position].alive = true;
                armyHeroes[position].spellAgainst = "goblinFear"; 
                armyHeroes[position].type = "Hobbit";
                armyHeroes[position].lifepoints = 200;  
            } else System.out.println("------Not in range-----");
                break;

            default:
            System.out.println("------Not in range-----");
                break;
        }
    }

}
