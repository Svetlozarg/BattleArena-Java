import java.util.ArrayList;
import java.util.Collection;

public class Guild {

    public ArrayList<Character> members;

    public Guild() {
        this.members = new ArrayList<>();
    }

    // Add member to the guild
    public void addMember(Character member) {
        this.members.add(member);
    }

    // Return all members of the guild
    public Collection<Character> getMembers() {
        return this.members;
    }

    // Makes a team of 5 alive guild members
    public ArrayList<Character> getTeam(Team enemyTeam) {
        int num = 0;
        ArrayList<Character> membersTeam = new ArrayList<>();
        for (Character character : members) {
            num++;
            if(num <= 5) {
                if (character.currentHP > 0) {
                    membersTeam.add(this.members.get(num));
                }
            } else {
                break;
            }
        }
        return membersTeam;
    }

}
