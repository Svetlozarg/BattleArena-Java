import java.util.Random;

public class Minion extends Character implements Monster{

    public static final int baseHP = 5;
    public static final int baseAtk = 5;
    public static final int baseDef = 5;
    public static final int baseSpd = 5;
    public String minionName;

    public Minion(String name) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.minionName = name;
    }

    // Strike method chooses random ability each time with it's specific range of percentage
    public void strike(Character enemy) {
        Random r = new Random();
        int num = r.nextInt(100);

        // 75% chance for SyntaxError
        if(num <= 75) {
            System.out.println(this.getName() + " is using SyntaxError on " + enemy.getName());
            SyntaxError(enemy);
        } // 15 % chance for NullPointerException
        if(num > 75 && num <= 90) {
            System.out.println(this.getName() + " is using NullPointerException on " + enemy.getName());
            NullPointerException();
        } // 10% chance for ArrayIndexOutOfBoundException
        if(num > 90) {
            System.out.println(this.getName() + " is using ArrayIndexOutOfBoundException on " + enemy.getName());
            ArrayIndexOutOfBoundException(enemy);
        }
    }

    // SyntaxError ability allows the minion to attack an enemy with the formula
    public void SyntaxError(Character enemy) {
        int damage = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damage);
        if(enemy.currentHP <= 0) {
            this.increaseEP(4);
        }

        this.increaseEP(3);
        enemy.increaseEP(3);
        if(enemy.getClass().equals(Student.class)) {
            ((Student) enemy).increaseKP(3);
        }
    }

    // NullPointerException ability heals the minion with the amount of it's defence
    public void NullPointerException() {
        this.increaseHP(this.getDefence());
        this.increaseEP(3);
    }

    // ArrayIndexOutOfBoundException ability allows the minion to deal double damage to the enemy
    public void ArrayIndexOutOfBoundException(Character enemy) {
        enemy.decreaseHP(this.getAttack() * 2);
        if(enemy.currentHP <= 0) {
            this.increaseEP(4);
        }

        this.increaseEP(3);
        enemy.increaseEP(3);
        if(enemy.getClass().equals(Student.class)) {
            ((Student) enemy).increaseKP(3);
        }
    }
}
