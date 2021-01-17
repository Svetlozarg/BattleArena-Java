import java.util.ArrayList;

public class Team {

    public String name;
    public ArrayList<Character> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    // Abstract move method for the student and monster team
    public void move(Character member, Team enemyTeam) {}

    // Get the name of the team
    public String getName() {
        return this.name;
    }

    // Get all members as an array
    public Character[] getMembers() {
        return this.members.toArray(new Character[0]);
    }

    // Add member only if the size of the team is less than 5 and the member doesn't
    // already exist in the team
    public int addMember(Character member) {
        int status;
        if (this.members.contains(member)) {
            status = -1;
        } else if (this.members.size() == 5) {
            status = -2;
        } else {
            this.members.add(member);
            status = this.members.size();
        }
        return status;
    }

}
