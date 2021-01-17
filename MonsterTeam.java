public class MonsterTeam extends Team{

    public MonsterTeam(String name) {
        super(name);
    }

    // The move method for the monster team allows a member to attack an enemy team
    public void move(Character member, Team enemyTeam) {
        // Loop trough the whole enemy team so the member can attack all enemies
        for (Character enemy : enemyTeam.getMembers()) {
            if(enemy.currentHP > 0) {
                // Minion
                if(member.getClass().equals(Minion.class)) {
                    // Attack the chosen enemy
                    enemy.decreaseHP(member.getAttack());
                    ((Minion) member).strike(enemy);
                }
                // Boss
                if(member.getClass().equals(Boss.class)) {
                    // Attack the chosen enemy
                    enemy.decreaseHP(member.getAttack());
                    ((Boss) member).strike(enemy);
                }

                break;
            }
        }
    }
}
