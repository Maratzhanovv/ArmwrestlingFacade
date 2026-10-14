public class Main {
    public static void main(String[] args) {
        TournamentFacade tournament = new TournamentFacade();
        try {
            tournament.registerParticipant("Madi", 68);
            tournament.registerParticipant("Aibek", 70);
            tournament.registerParticipant("Miras", 82);
            tournament.registerParticipant("Ali", 88);
            tournament.registerParticipant("Arman", 95);
            tournament.registerParticipant("Dias", 102);

            System.out.println("Tournament schedule:");

            for (String match : tournament.startTournament()) {
                System.out.println(match);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}