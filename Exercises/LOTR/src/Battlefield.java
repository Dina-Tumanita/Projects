
import java.util.concurrent.TimeUnit;

public class Battlefield {
    public Soldier soldier;
    public Dice dice = new Dice();

    private int attackBuffs(Soldier soldier1, Soldier soldier2){
        String buff1 = soldier1.spellAgainst;
        int modifier;
        String enemyType = soldier2.type;
        int finalDMG = 0;

            if (buff1 == "NULL") finalDMG = soldier1.attack();
            else if (buff1 == "orcFear"){
                if (enemyType == "Orc"){ 
                    System.out.println(soldier1.type+ " is angry!");
                    System.out.println(soldier1.type+ " will throw dice for extra damage");
                    modifier = dice.isThrown(1, 10);
                    System.out.println("+"+modifier+" attack points \n");
                    finalDMG = soldier1.attack() + modifier;
                }

            } else if (buff1 != "goblinFear"){
                if (enemyType == "Goblin"){ 
                    modifier = 5;
                    System.out.println(soldier1.type+ " is afraid!");
                    System.out.println("-"+modifier+" attack points \n");
                    finalDMG = soldier1.attack() - modifier;
                }
            } 
            return finalDMG;     
    }

    private int armorDebuff(Soldier soldier1, Soldier soldier2){
        String buff1 = soldier1.spellAgainst;
        double modifier = 0.9;
        int finalArmor = soldier2.armorSet();

            if (buff1 == "armorAll"){
                System.out.println(soldier1.type+ " is STRONG!");
                System.out.println(modifier*100 + "% armor for "+ soldier2.type+" \n");
                finalArmor = (int) (finalArmor * modifier);       
            }  
            return finalArmor;     
    }



    public void attack(Soldier soldier1, Soldier soldier2){

        int soldierDMG = attackBuffs(soldier1, soldier2);       //if needed
        int soldierArmor = armorDebuff(soldier1, soldier2);
        System.out.println(soldier1.type+" attacks for "+soldierDMG);
        System.out.println(soldier2.type +" defends with "+ soldierArmor+ "\n");
        soldier2.defend(soldierDMG, soldierArmor);
        sleep(3);
        sleep(3);

        System.out.println(soldier1.type+"\n Lifepoints: " +soldier1.lifepoints+"\n Armor: " + soldier1.armor);
        System.out.println(soldier2.type+"\n Lifepoints: " +soldier2.lifepoints+"\n Armor: " + soldierArmor);
        sleep(5);

     }

     private void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
     }

}