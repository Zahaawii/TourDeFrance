import java.util.*;

public class Statistics {
    private Set<String> teams = new HashSet<>();
    private Map<String, Set<String>> teamsWithMembers = new HashMap<>();

    public Statistics(List<Cyclist> cyclists) {
        for (Cyclist c : cyclists) {
            teams.add(c.getTeam());

            teamsWithMembers.putIfAbsent(c.getTeam(), new HashSet<>());
            teamsWithMembers.get(c.getTeam()).add(c.getName());
        }
    }

    public Set<String> getTeams() {
        return teams;
    }

    public Map<String, Set<String>> getTeamsWithMembers() {
        return teamsWithMembers;
    }

    public Set<String> getTeamMembers(String team) {
        return teamsWithMembers.getOrDefault(team, new HashSet<>());
    }
}
