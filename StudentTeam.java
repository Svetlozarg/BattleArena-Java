import javax.swing.text.html.CSS;
import java.util.Random;

public class StudentTeam extends Team {

    public StudentTeam(String name) {
        super(name);
    }

    // The move method for the student team allows a member to attack an enemy team
    public void move(Character member, Team enemyTeam) {

        for (Character enemy : enemyTeam.getMembers()) {
            if (enemy.currentHP > 0) {
                // CSStudent
                if (member.getClass().equals(CSStudent.class)) {
                    // Attack the chosen enemy
                    System.out.println(member.getName() + " is attacking " + enemy.getName());
                    enemy.decreaseHP(member.getAttack());

                    // Check for maxKP to use Ability
                    if (((CSStudent) member).currentKP >= CSStudent.maxKP) {
                        for (Character friend : member.getTeam().getMembers()) {
                            if (friend.currentHP > 0) {
                                try {
                                    // Use ability on enemy
                                    System.out.println(member.getName() + " is using pairWorking Ability");
                                    ((CSStudent) member).pairWorking(friend, enemy);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                    } else {
                        Random rand = new Random();
                        int num = rand.nextInt(100);
                        if (num > 0 && num <= 80) {
                            // If not enough KP points, use selfStudy ability
                            System.out.println(member.getName() + " is using selfStudy ability");
                            ((CSStudent) member).selfStudy();
                        } else if (num > 50) {
                            // If not enough KP points, use javaProgramming ability
                            System.out.println(member.getName() + " is using javaProgramming ability");
                            ((CSStudent) member).javaProgramming(enemy);
                        }
                    }
                    break;
                }

                // AIStudent
                if (member.getClass().equals(AIStudent.class)) {
                    // Attack the chosen enemy
                    System.out.println(member.getName() + " is attacking " + enemy.getName());
                    enemy.decreaseHP(member.getAttack());

                    // Check for maxKP to use Ability
                    if (((AIStudent) member).currentKP >= AIStudent.maxKP) {
                        for (Character getEnemy : enemyTeam.getMembers()) {
                            if (getEnemy.currentHP > 0) {
                                try {
                                    // Use ability on enemy
                                    System.out.println(member.getName() + " is using machineLearning ability");
                                    ((AIStudent) member).machineLearning(getEnemy);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                    } else {
                        Random rand = new Random();
                        int num = rand.nextInt(100);
                        if (num > 0 && num <= 80) {
                            // If not enough KP points, use selfStudy ability
                            System.out.println(member.getName() + " is using selfStudy ability");
                            ((AIStudent) member).selfStudy();
                        } else if (num > 50) {
                            // If not enough KP points, use javaProgramming ability
                            System.out.println(member.getName() + " is using javaProgramming ability");
                            ((AIStudent) member).javaProgramming(enemy);
                        }
                    }
                    break;
                }

                // CyberStudent
                if (member.getClass().equals(CyberStudent.class)) {
                    // Attack the chosen enemy
                    System.out.println(member.getName() + " is attacking " + enemy.getName());
                    enemy.decreaseHP(member.getAttack());

                    // Check for maxKP to use Ability
                    if (((CyberStudent) member).currentKP >= CyberStudent.maxKP) {
                        for (Character charEnemy : enemyTeam.getMembers()) {
                            if (charEnemy.currentHP > 0) {
                                try {
                                    // Use ability on enemy
                                    System.out.println(member.getName() + " is using cyberAttack ability");
                                    ((CyberStudent) member).cyberAttack(enemyTeam);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                    } else {
                        Random rand = new Random();
                        int num = rand.nextInt(100);
                        if (num > 0 && num <= 80) {
                            // If not enough KP points, use selfStudy ability
                            System.out.println(member.getName() + " is using selfStudy ability");
                            ((CyberStudent) member).selfStudy();
                        } else if (num > 50) {
                            // If not enough KP points, use javaProgramming ability
                            System.out.println(member.getName() + " is using javaProgramming ability");
                            ((CyberStudent) member).javaProgramming(enemy);
                        }
                    }
                    break;
                }

                // SEStudent
                if (member.getClass().equals(SEStudent.class)) {
                    // Attack the chosen enemy
                    System.out.println(member.getName() + " is attacking " + enemy.getName());
                    enemy.decreaseHP(member.getAttack());

                    // Check for maxKP to use Ability
                    if (((SEStudent) member).currentKP >= SEStudent.maxKP) {
                        for (Character teammate : member.getTeam().getMembers()) {
                            if (teammate.currentHP > 0) {
                                try {
                                    // Use ability on enemy
                                    System.out.println(member.getName() + " is using groupWork ability");
                                    ((SEStudent) member).groupWork(enemy);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                    } else {
                        Random rand = new Random();
                        int num = rand.nextInt(100);
                        if (num > 0 && num <= 80) {
                            // If not enough KP points, use selfStudy ability
                            System.out.println(member.getName() + " is using selfStudy ability");
                            ((SEStudent) member).selfStudy();
                        } else if (num > 50) {
                            // If not enough KP points, use javaProgramming ability
                            System.out.println(member.getName() + " is using javaProgramming ability");
                            ((SEStudent) member).javaProgramming(enemy);
                        }
                    }
                    break;
                }

            }
        }
    }
}
