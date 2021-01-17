public class CSStudent extends Student{

    public static final int baseHP = 7;
    public static final int baseAtk = 6;
    public static final int baseDef = 6;
    public static final int baseSpd = 6;
    public static final int maxKP = 4;
    public String studentName;

    public CSStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // PairWorking checks if the max KP are reached and if so allows the current student to group with an alive friend and
    // attack the enemy
    public void pairWorking(Character friend, Character enemy) throws Exception {
        if(this.currentKP >= maxKP) {
            if(friend.currentHP > 0 && enemy.currentHP > 0) {
                enemy.decreaseHP(this.getAttack() + friend.getAttack());
                this.increaseEP(4);
                this.currentKP = 0;
            }

            if(enemy.currentHP <= 0) {
                this.increaseEP(4);
            }
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

    // Support checks if the max KP are reached and if so to heal an alive friend with the amount of the student's defence
    public void support(Character friend) throws Exception {
        if(this.currentKP >= maxKP) {
            if(friend.currentHP > 0) {
                friend.increaseHP(getDefence());
                this.increaseEP(4);
                this.currentKP = 0;
            }
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

}
