
abstract class Hero extends Soldier {

    int dicethrows ;
    int attackdmg ; 
    int armor;
    boolean alive;

}

class Human extends Hero{

    final int dicethrows = 2;
    final int attackdmg = 100; 
    final int armor = 30;
    boolean alive = true;
    final String spellAgainst = "NULL"; 
    final String type = "Human";
    int lifepoints = 180;  

}

class Hobbit extends Hero{

    final int dicethrows = 2;
    final int attackdmg = 100; 
    final int armor = 30;
    boolean alive = true;
    final String spellAgainst = "goblinFear"; 
    int lifepoints = 200; 
    final String type = "Hobbit";
}

class Elf extends Hero{

    final int dicethrows = 2;
    final int attackdmg = 100; 
    final int armor = 30;
    boolean alive = true;
    final String spellAgainst = "orcFear"; 
    int lifepoints = 250; 
    final String type = "Elf";
}

