import java.util.Random;

public class Boss extends Character implements Monster {

    public static final int baseHP = 8;
    public static final int baseAtk = 7;
    public static final int baseDef = 8;
    public static final int baseSpd = 7;
    public String minionName;

    public Boss(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.minionName = name;
    }

    // Strike method chooses random ability each time with it's specific range of percentage
    public void strike(Character enemy) {
        Random r = new Random();
        int num = r.nextInt(100);

        // 50% chance for SyntaxError
        if (num <= 50) {
            System.out.println(this.getName() + " is using SyntaxError on" + enemy.getName());
            SyntaxError(enemy);
        } // 15% chance for NullPointerException
        if (num > 50 && num <= 65) {
            System.out.println(this.getName() + " is using NullPointerException on " + enemy.getName());
            NullPointerException();
        } // 15% chance for ArrayIndexOutOfBoundException
        if (num > 65 && num <= 80) {
            System.out.println(this.getName() + " is using ArrayIndexOutOfBoundException on " + enemy.getName());
            ArrayIndexOutOfBoundException(enemy);
        } // 10% chance for NoneTermination
        if (num > 80 && num <= 90) {
            System.out.println(this.getName() + " is using NoneTermination on " + enemy.getName());
            NoneTermination();
        } // 10% chance for ConcurrentModificationException
        if (num > 90) {
            System.out.println(this.getName() + " is using ConcurrentModificationException on " + enemy.getName());
            ConcurrentModificationException(enemy.getTeam());
        }
    }

    // SyntaxError ability allows the boss to attack an enemy with the formula
    public void SyntaxError(Character enemy) {
        int damage = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damage);
        if (enemy.currentHP <= 0) {
            this.increaseEP(4);
        }

        this.increaseEP(3);
        enemy.increaseEP(3);
        if (enemy.getClass().equals(Student.class)) {
            ((Student) enemy).increaseKP(3);
        }
    }

    // NullPointerException ability heals the boss with the amount of it's defence
    public void NullPointerException() {
        this.increaseHP(this.getDefence());
        this.increaseEP(3);
    }

    // ArrayIndexOutOfBoundException ability allows the boss to deal double damage to the enemy
    public void ArrayIndexOutOfBoundException(Character enemy) {
        enemy.decreaseHP(this.getAttack() * 2);
        if (enemy.currentHP <= 0) {
            this.increaseEP(4);
        }

        this.increaseEP(3);
        enemy.increaseEP(3);
        if (enemy.getClass().equals(Student.class)) {
            ((Student) enemy).increaseKP(3);
        }
    }

    // NoneTermination ability allows the boss to resurrect all fallen members if it's team
    public void NoneTermination() {
        for (Character member : this.teamName.getMembers()) {
            member.currentHP = member.getMaxHP();
        }
        this.increaseEP(3);
    }

    // ConcurrentModificationException ability allows the boss to deal double damage to all alive enemies.
    // The damage is calculated with specific formula
    public void ConcurrentModificationException(Team enemyTeam) {
        for (Character enemy : enemyTeam.getMembers()) {
            if (enemy.currentHP > 0) {
                int damage = (100 * this.getAttack()) / (100 + enemy.getDefence());
                enemy.decreaseHP(damage);
                if (enemy.currentHP <= 0) {
                    this.increaseEP(4);
                }

                enemy.increaseEP(3);
                if (enemy.getClass().equals(Student.class)) {
                    ((Student) enemy).increaseKP(3);
                }
            }
        }
        this.increaseEP(3);
    }

}
