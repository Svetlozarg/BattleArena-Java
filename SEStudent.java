public class SEStudent extends Student {

    public static final int baseHP = 8;
    public static final int baseAtk = 5;
    public static final int baseDef = 8;
    public static final int baseSpd = 4;
    public static final int maxKP = 10;
    public String studentName;

    public SEStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // GroupWork ability checks if the max KP are reached and if so allows all alive member's of the student's team to
    // attack an enemy
    public void groupWork(Character enemy) throws Exception {
        if (this.currentKP >= maxKP) {
            for (Character member : this.getTeam().getMembers()) {
                enemy.decreaseHP(member.getAttack());
            }
            if (enemy.currentHP <= 0) {
                this.increaseEP(4);
            }
            this.currentKP = 0;
            this.increaseEP(4);
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

    // GroupDiscussion check if the max KP are reached and if so allows the student to heal all alive members of it's team
    // with the amount of half it's defence
    public void groupDiscussion() throws Exception {
        if (this.currentKP >= maxKP) {
            for (Character member : this.getTeam().getMembers()) {
                if (member.currentHP > 0) {
                    member.increaseHP(this.getDefence() / 2);
                }
            }
            this.increaseEP(4);
            this.currentKP = 0;
        } else {
            throw new Exception("You don't have enough KP points");
        }
    }

}
