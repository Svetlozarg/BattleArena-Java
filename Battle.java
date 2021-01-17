import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Battle {

    Team students, monsters;

    Battle(Team students, Team monsters) {
        this.students = students;
        this.monsters = monsters;
    }

    public void fight() throws Exception {
        int round = 0;

        // New ArrayList of characters for the order of the members
        ArrayList<Character> membersOrder = new ArrayList<>();

        while (round < 30) {
            // Add +1 to the current round
            System.out.println();
            round++;
            System.out.println("---Round " + round + "---");

            // Clear the old array
            membersOrder.clear();
            // Add the alive students
            for (Character student : students.getMembers()) {
                if (student.currentHP > 0) {
                    membersOrder.add(student);
                }
            }
            // Add the alive monsters
            for (Character monster : monsters.getMembers()) {
                if (monster.currentHP > 0) {
                    membersOrder.add(monster);
                }
            }

            // Sort the ArrayList by speed
            membersOrder.sort(new Comparator<>() {
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });

            // Loop trough the order of the round
            for (Character character : membersOrder) {
                try {
                    Thread.sleep(500);
                    // Check if it is a student's move and call the move() method
                    if(character.getClass() == CSStudent.class ||
                            character.getClass() == AIStudent.class ||
                            character.getClass() == CyberStudent.class ||
                            character.getClass() == SEStudent.class) {
                        if(character.currentHP > 0) {
                            students.move(character, monsters);
                        }
                    }
                    // Check if it is a monster's turn and call the move() method
                    if(character.getClass() == Minion.class || character.getClass() == Boss.class) {
                        if(character.currentHP > 0) {
                            monsters.move(character, students);
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Check if students won the level
            int studentCount = 0;
            for (Character monster : monsters.getMembers()) {
                if (monster.currentHP <= 0) {
                    studentCount++;
                }
            }
            if(studentCount == 5) {
                System.out.println();
                System.out.println();
                System.out.println("##########Students won the level##########");
                break;
            }

            // Check if monsters won the level
            int monsterCount = 0;
            for (Character student : students.getMembers()) {
                if (student.currentHP <= 0) {
                    monsterCount++;
                }
            }
            if(monsterCount == 5) {
                System.out.println();
                System.out.println();
                System.out.println("##########Monsters won the level##########");
                break;
            } else if (students.getMembers().length <= 0) {
                System.out.println();
                System.out.println();
                System.out.println("##########Monsters won the level##########");
                break;
            }

            // Check if the game is more than 30 rounds and if so call it a draw
            if (round == 30) {
                System.out.println();
                System.out.println();
                System.out.println("##########Its a draw##########");
                break;
            }
        }

    }

}
