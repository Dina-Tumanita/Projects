abstract class Beast extends Soldier {
    int dicethrows;
    int attackdmg;
    int armor;
    boolean alive;
}

class Goblin extends Beast{
    final int dicethrows = 1;
    final int attackdmg = 90;
    final int armor = 50;
    boolean alive = true;
    final String spellAgainst = "NULL"; 
    final String type = "Goblin";
    int lifepoints = 325;
}

class Orc extends Beast{
    final int dicethrows = 1;
    final int attackdmg = 90;
    final int armor = 50;
    boolean alive = true;
    final String spellAgainst = "armorAll"; 
    final String type = "Orc";
    int lifepoints = 300;
    
}
