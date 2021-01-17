import java.io.*;
import java.util.ArrayList;

public class TowerOfMonsters {

    public static ArrayList<Team> monsterTeamList;

    public static Team monsterTeam;
    public static Team studentTeam;

    public static BufferedReader reader;

    public static String text;

    public static void main(String[] args) {
        // Check if a configuration file is provided
        if (args.length < 1) {
            System.err.println("No configuration file is provided");
            System.exit(1);
        }
        // Read the file
        try {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Tower of Monsters

        // Create guild for students
        Guild studentGuild = new Guild();

        // Create students and add them to the guild
        CSStudent csStudent = new CSStudent("CSStudent1");
        studentGuild.addMember(csStudent);
        CSStudent csStudent2 = new CSStudent("CSStudent2");
        studentGuild.addMember(csStudent2);

        CyberStudent cyberStudent1 = new CyberStudent("CyberStudent1");
        studentGuild.addMember(cyberStudent1);
        CyberStudent cyberStudent2 = new CyberStudent("CyberStudent2");
        studentGuild.addMember(cyberStudent2);

        AIStudent aiStudent1 = new AIStudent("AIStudent1");
        studentGuild.addMember(aiStudent1);
        AIStudent aiStudent2 = new AIStudent("AIStudent2");
        studentGuild.addMember(aiStudent2);

        SEStudent seStudent1 = new SEStudent("SEStudent1");
        studentGuild.addMember(seStudent1);
        SEStudent seStudent2 = new SEStudent("SEStudent2");
        studentGuild.addMember(seStudent2);

        AEStudent aeStudent = new AEStudent("AEStudent");
        studentGuild.addMember(aeStudent);
        BEStudent beStudent = new BEStudent("BEStudent");
        studentGuild.addMember(beStudent);
        EEStudent eeStudent = new EEStudent("EEStudent");
        studentGuild.addMember(eeStudent);

        // Create the game
        String line;
        int level = 0;
        // Execute until there are no more line in the given text file
        while ((line = getLine()) != null) {
            try {
                // Add +1 to the current level
                level++;
                System.out.println("----------Level " + level + "----------");
                System.out.println();

                // Create the student's team
                studentTeam = new StudentTeam("Student Team");

                // Show the chosen members and their current level
                System.out.println("**********" + studentTeam.getName() + "**********");
                for (Character character : studentGuild.getTeam(monsterTeam)) {
                    studentTeam.addMember(character);
                }
                for (Character student : studentTeam.getMembers()) {
                    System.out.print(student.getName() + " : Level:" + student.level + ", ");
                }

                System.out.println();
                System.out.println();

                // Show the enemies for the current level with their level
                monsterTeam = new MonsterTeam("Monster Team");
                System.out.println("**********" + monsterTeam.getName() + "**********");
                getEnemyTeams();
                monsterTeam = monsterTeamList.get(level);
                for (Character monster : monsterTeam.getMembers()) {
                    System.out.print(monster.getName() + " : Level:" + monster.level + ", ");
                }

                System.out.println();
                System.out.println();

                // Create the battle and call the fight() method
                System.out.println("**********Battle**********");
                Battle battle = new Battle(studentTeam, monsterTeam);
                try {
                    battle.fight();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println();
                System.out.println();

                // Report
                System.out.println("**********Report**********");
                System.out.println();
                // Give report for the members with their current level and hp
                for (Character student : studentTeam.getMembers()) {
                    System.out.print(student.getName() + ":Lvl " + student.level + " : HP:" + student.currentHP + ", ");
                }
                System.out.println();
                System.out.println();
                // Give report for the monsters with their current level and hp
                for (Character monster : monsterTeam.getMembers()) {
                    System.out.print(monster.getName() + ":Lvl " + monster.level + " : HP:" + monster.currentHP + ", ");
                }
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }

            // Check if monsters won the game
            int liveStudents = 0;
            for (Character student : studentGuild.getMembers()) {
                if (student.currentHP <= 0) {
                    liveStudents++;
                }
            }
            if (liveStudents == 5) {
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println(" " + studentTeam.getName() + " survived until " + level + " round");

                System.out.println("#####################################");
                System.out.println("#      " + monsterTeam.getName() + " won the game     #");
                System.out.println("#####################################");
                break;
            }

            // Check if students won the game
            if ((line = getLine()) == null) {
                System.out.println("#####################################");
                System.out.println("#      " + studentTeam.getName() + " won the game     #");
                System.out.println("#####################################");
                break;
            }

        }
    }

    // Read a line from a text file
    public static String getLine() {
        try {
            text = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return text;
    }

    // Make the monster team from a text file
    public static void getEnemyTeams() {
        monsterTeamList = new ArrayList<>();
        String[] textPieces = getLine().split(";");
        Team enemyTeam = new MonsterTeam("MonsterTeam");

        // Loop trough the whole line and split by specific characters to get the name,
        // type and level ot monster
        for (String piece : textPieces) {
            String[] pieces = piece.split("\\(");
            // Get Name
            String name = pieces[0];
            String[] typePieces = pieces[1].split(",");
            // Get Type
            String type = typePieces[0];
            String[] levelPiece = typePieces[1].split("\\)");
            // Get Level
            int level = Integer.parseInt(levelPiece[0]);

            // Check if Minion
            if (type.equals("Minion")) {
                Minion minion = new Minion(name);
                minion.level = level;
                enemyTeam.addMember(minion);
            }
            // Check if Boss
            if (type.equals("Boss")) {
                Boss boss = new Boss(name);
                boss.level = level;
                enemyTeam.addMember(boss);
            }
            monsterTeamList.add(enemyTeam);
        }
    }

}