// Aerospace Electronic Engineering Student
public class AEStudent extends Student{

    public static final int baseHP = 7;
    public static final int baseAtk = 6;
    public static final int baseDef = 6;
    public static final int baseSpd = 6;
    public static final int maxKP = 4;
    public String studentName;

    public AEStudent(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd, maxKP);
        this.studentName = name;
    }

    // aerospaceSystemsEngineering check if the max KP are reached and if so allows the student to heal all alive members of it's team
    // with the amount of half it's defence
    public void aerospaceSystemsEngineering() throws Exception {
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
