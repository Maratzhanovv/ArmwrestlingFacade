import java.util.ArrayList;
import java.util.List;
public class RegistrationService {
    private final List<Participant> participants = new ArrayList<>();

    public void register(Participant participant) {
        if (participant == null) {
            throw new IllegalArgumentException("Participant cannot be null");
        }

        for (Participant existing : participants) {
            if (existing.getName().equalsIgnoreCase(participant.getName())) {
                throw new IllegalArgumentException(
                        "Participant already registered: " + participant.getName()
                );
            }
        }

        participants.add(participant);
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }
}
