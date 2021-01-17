public class Student extends Character{

    public int maxKP, currentKP;

    public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.maxKP = maxKP;
        this.currentKP = 0;
    }

    // Increase the current KP of the student
    public void increaseKP(int amount){
        if (amount > 0) {
            this.currentKP += amount;
        }
    }

    // JavaProgramming ability that increases the current EP by 3, the current KP by 1, decreases the enemy's HP by the formula
    // and increases the enemy EP by 2. If the enemy is a student, increases the enemy KP by further 3 and if the enemy is dead
    // increases the attacker's current EP by further 4.
    public void javaProgramming(Character enemy){
        this.increaseEP(3);
        this.increaseKP(1);
        enemy.decreaseHP(100 * this.getAttack() / (100 + enemy.getDefence()));
        enemy.increaseEP(2);

        if (enemy.getClass().equals(Student.class)) {
            ((Student) enemy).increaseKP(3);
        }
        if (enemy.currentHP == 0) {
            this.increaseEP(4);
        }
    }

    // SelfStudy ability increases the current HP by 2, the current EP by 6 and the current KP by 2
    public void selfStudy(){
        this.increaseHP(2);
        this.increaseEP(6);
        this.increaseKP(2);
    }
}
