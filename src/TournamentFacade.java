import java.time.LocalTime;
import java.util.List;
import java.util.Map;
public class TournamentFacade {
    private final RegistrationService registration =
            new RegistrationService();
    private final WeightCategoryService categories =
            new WeightCategoryService();
    private final PairingService pairing =
            new PairingService();
    private final ScheduleService scheduling =
            new ScheduleService();

    private boolean started;

    public void registerParticipant(String name, double weight) {
        if (started) {
            throw new IllegalStateException("Registration is closed");
        }
        registration.register(new Participant(name, weight));
    }

    public List<String> startTournament() {
        if (started) {
            throw new IllegalStateException("Tournament already started");
        }

        List<Participant> participants = registration.getParticipants();

        if (participants.size() < 2) {
            throw new IllegalStateException(
                    "At least two participants are required"
            );
        }

        Map<String, List<Participant>> groups =
                categories.groupByWeight(participants);
        List<String> pairings = pairing.createPairings(groups);
        List<String> schedule = scheduling.createSchedule(
                pairings, LocalTime.of(10, 0), 10
        );

        started = true;
        return schedule;
    }
}