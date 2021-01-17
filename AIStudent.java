public class AIStudent extends Student {

    public static final int baseHP = 6;
    public static final int baseAtk = 7;
    public static final int baseDef = 7;
    public static final int baseSpd = 5;
    public static final int maxKP = 3;
    public String studentName;

    public AIStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // MachineLearning ability checks if the max KP are reached and if so to attack an alive enemy and cause double damage
    public void machineLearning(Character enemy) throws Exception {
        if (this.currentKP >= maxKP) {
            if (enemy.currentHP > 0) {
                enemy.decreaseHP(this.getAttack() * 2);
                this.increaseEP(4);
                this.currentKP = 0;
            }

            if (enemy.currentHP <= 0) {
                this.increaseEP(4);
            }
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

    // NaturalLanguageProcessing ability checks if the max KP are reached and if so to heal the student with the amount of
    // its defence
    public void naturalLanguageProcessing() throws Exception {
        if (this.currentKP >= maxKP) {
            this.increaseHP(getDefence());
            this.increaseEP(4);
            this.currentKP = 0;
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }
}
