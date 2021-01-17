public class CyberStudent extends Student {

    public static final int baseHP = 7;
    public static final int baseAtk = 7;
    public static final int baseDef = 5;
    public static final int baseSpd = 6;
    public static final int maxKP = 6;
    public String studentName;

    public CyberStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // CyberAttack ability checks if the max KP are reached and if so allows the student to attack the entire enemy team
    public void cyberAttack(Team enemyTeam) throws Exception {
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
