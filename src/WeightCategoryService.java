import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class WeightCategoryService {
    public Map<String, List<Participant>> groupByWeight(
            List<Participant> participants) {

        Map<String, List<Participant>> categories = new LinkedHashMap<>();
        categories.put("Up to 70 kg", new ArrayList<>());
        categories.put("Up to 90 kg", new ArrayList<>());
        categories.put("Over 90 kg", new ArrayList<>());

        for (Participant participant : participants) {
            String category = getCategory(participant.getWeight());
            categories.get(category).add(participant);
        }

        return categories;
    }

    private String getCategory(double weight) {
        if (weight <= 70) {
            return "Up to 70 kg";
        }
        if (weight <= 90) {
            return "Up to 90 kg";
        }
        return "Over 90 kg";
    }
}
