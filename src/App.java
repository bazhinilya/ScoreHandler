public class App {

    private static int getHomeTeamGoals(String score) {
        try {
            return Integer.parseInt(score.split("[: ]")[0]);
        } catch (NumberFormatException e) {
            System.err.println("\tInnerError: " + e.getMessage() + " -> Incorrect data");
            return Integer.MAX_VALUE;
        }
    }

    private static int getOtherTeamGoals(String score) {
        try {
            return Integer.parseInt(score.split("[: ]")[1]);
        } catch (NumberFormatException e) {
            System.err.println("\tInnerError: " + e.getMessage() + " -> Incorrect data");
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] matchResults = { "3:1", "2:2", "0:1", "4:2", "3:a", "3- 12" };

        int homeTeamScore = 0;
        int otherTeamScore = 0;

        for (String matchResult : matchResults) {
            int homeTeamGoals = getHomeTeamGoals(matchResult);
            int otherTeamGoals = getOtherTeamGoals(matchResult);

            if (homeTeamGoals != Integer.MAX_VALUE && otherTeamGoals != Integer.MAX_VALUE) {
                homeTeamScore += homeTeamGoals == otherTeamGoals ? 1 : homeTeamGoals > otherTeamGoals ? 3 : 0;
                otherTeamScore += otherTeamGoals == homeTeamGoals ? 1 : otherTeamGoals > homeTeamGoals ? 3 : 0;
            }
        }
        System.out.println("Score teams = { Home: " + homeTeamScore + " Other: " + otherTeamScore + " }");
    }
}