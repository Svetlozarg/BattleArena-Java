// Biomedical Electronic Engineering Student
public class BEStudent extends Student{

    public static final int baseHP = 10;
    public static final int baseAtk = 4;
    public static final int baseDef = 6;
    public static final int baseSpd = 2;
    public static final int maxKP = 5;
    public String studentName;

    public BEStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // biomolecularSystems ability checks if the max KP are reached and if so allows the student to attack the entire enemy team
    public void biomolecularSystems(Team enemyTeam) throws Exception {
        if(this.currentKP >= maxKP) {
            for (Character enemy : enemyTeam.getMembers()) {
                if(enemy.currentHP > 0) {
                    enemy.decreaseHP(this.getAttack());
                }

                if (enemy.currentHP <= 0) {
                    this.increaseEP(4);
                }
            }
            this.increaseEP(4);
            this.currentKP = 0;
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

}
