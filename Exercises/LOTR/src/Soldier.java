
abstract class Soldier {
    int lifepoints;
    int armor;
    int attackdmg;
    boolean alive = true;
    int dicethrows;
    String type;
    String spellAgainst;

    public Dice dice = new Dice();

    public void defend(int attackDMG, int finalArmor){
      if (attackDMG > armor ||attackDMG == armor ){
        this.lifepoints = this.lifepoints - (attackDMG-finalArmor);
        if (this.lifepoints <= 0){
          this.alive = false;
          System.out.println(this.type + " has perished. ");
        }
      }
      else {
        System.out.println("Not enough Attack Damage");
      }
      }

      public int attack(){
        System.out.println(this.type+ " will throw Dice for attack");
        return dice.isThrown(dicethrows, this.attackdmg);
      }

      public int armorSet(){
        System.out.println(this.type + " will throw Dice for armor");
        return dice.isThrown(1, this.armor);
      }

}

