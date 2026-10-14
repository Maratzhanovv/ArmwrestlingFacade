import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class ScheduleService {
    public List<String> createSchedule(
            List<String> pairings, LocalTime startTime,
            int matchDurationMinutes) {

        if (startTime == null) {
            throw new IllegalArgumentException("Start time is required");
        }
        if (matchDurationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }

        List<String> schedule = new ArrayList<>();
        LocalTime currentTime = startTime;

        for (String pairing : pairings) {
            if (pairing.endsWith("advances automatically")) {
                schedule.add("BYE | " + pairing);
            } else {
                schedule.add(currentTime + " | " + pairing);
                currentTime = currentTime.plusMinutes(matchDurationMinutes);
            }
        }

        return schedule;
    }
}