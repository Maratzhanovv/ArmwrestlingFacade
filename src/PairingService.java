import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PairingService {
    public List<String> createPairings(
            Map<String, List<Participant>> categories) {

        List<String> pairings = new ArrayList<>();

        for (Map.Entry<String, List<Participant>> entry
                : categories.entrySet()) {

            List<Participant> group = new ArrayList<>(entry.getValue());
            Collections.shuffle(group);

            for (int i = 0; i < group.size(); i += 2) {
                String first = group.get(i).getName();
                String pairing;

                if (i + 1 < group.size()) {
                    String second = group.get(i + 1).getName();
                    pairing = first + " vs " + second;
                } else {
                    pairing = first + " advances automatically";
                }

                pairings.add(entry.getKey() + ": " + pairing);
            }
        }

        return pairings;
    }
}
