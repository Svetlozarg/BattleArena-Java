public class Character {

    public String name;
    public Team teamName;

    public final int baseHP;
    public final int baseAtk;
    public final int baseDef;
    public final int baseSpd;
    public int level;

    public int currentHP;
    public int currentEP;

    public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        this.name = name;
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
        this.level = 1;

        currentHP = baseHP;
        currentEP = 0;
    }

    // Get the name of the Character
    public String getName() {
        return this.name;
    }

    // Get the max HP of the character according to it's current level
    public int getMaxHP() {
        return (int) Math.round(this.baseHP * Math.pow(this.level, 1.2));
    }

    // Get the max Attack of the character according to it's current level
    public int getAttack() {
        return (int) Math.round(this.baseAtk * Math.pow(this.level, 1.2));
    }

    // Get the max Defence of the character according to it's current level
    public int getDefence() {
        return (int) Math.round(this.baseDef * Math.pow(this.level, 1.2));
    }

    // Get the max Speed of the character according to it's current level
    public int getSpeed() {
        return (int) Math.round(this.baseSpd * Math.pow(this.level, 1.2));
    }

    // Get the target EP of the character for the next level
    public int getTargetEP() {
        return (int) Math.round(10 * Math.pow(this.level, 1.5));
    }

    // Get the current HP of the character
    public int getHP() {
        return this.currentHP;
    }

    // Get the current EP of the character
    public int getEP() {
        return this.currentEP;
    }

    // Increase the current HP of the character
    public void increaseHP(int amount) {
        this.currentHP += amount;
        if (this.currentHP > getMaxHP()) {
            this.currentHP = getMaxHP();
        } else if (this.currentHP < 0) {
            this.currentHP = 0;
        }
    }

    // Decrease the current HP of the character
    public void decreaseHP(int amount) {
        if (currentHP > 0 && currentEP < baseHP) {
            this.currentHP -= amount;
            if (this.currentHP < 0) {
                this.currentHP = 0;
            }
        }
    }

    // Increase the current EP of the character
    public void increaseEP(int amount) {
        this.currentEP += amount;
        if (this.currentEP >= getTargetEP()) {
            this.level++;
            this.currentEP = 0;
            if (this.currentHP > 0) {
                this.currentHP = getMaxHP();
            }
        }
    }

    // Set the team name of the character
    public void setTeam(Team team) {
        this.teamName = team;
    }

    // Get the team name of the character
    public Team getTeam() {
        return this.teamName;
    }

    // Compare the speed of one character to another
    public int compareTo(Character character) {
        if (this.getSpeed() > character.getSpeed()) {
            return -1;
        } else if (this.getSpeed() < character.getSpeed()) {
            return 1;
        }
        return 0;
    }

}
