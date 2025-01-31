import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        TDFFileReader reader = new TDFFileReader("tdffinishers2024.csv");
        List<Cyclist> cyclists = reader.readFile();

        Statistics stats = new Statistics(cyclists);

        System.out.println("Hold:");
        for (String team : stats.getTeams()) {
            System.out.println(team);
        }

        System.out.println("\nHold og deres medlemmer:");
        for (Map.Entry<String, Set<String>> entry : stats.getTeamsWithMembers().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nRyttere fra UAE TEAM EMIRATES:");
        System.out.println(stats.getTeamMembers("UAE TEAM EMIRATES"));

    }
}
