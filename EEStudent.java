// Electronic Engineering Student
public class EEStudent extends Student{
    public static final int baseHP = 5;
    public static final int baseAtk = 7;
    public static final int baseDef = 6;
    public static final int baseSpd = 6;
    public static final int maxKP = 6;
    public String studentName;

    public EEStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // advancedProgramming checks if the max KP are reached and if so allows the current student to group with an alive friend and
    // attack the enemy
    public void advancedProgramming(Character friend, Character enemy) throws Exception {
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
}
