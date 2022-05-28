package creature;

import java.util.Map;

public class Creature {

    /**
     * Class represents creature.
     * Map: contains links between fields and their costs.
     * Key: field's name.
     * Value: field's cost.
     */
    private static Map<String, Integer> costs;
    private final Creature creature = null;
    Creature(final Map<String, Integer> costs) {
        Creature.costs = costs;
    }

    public int getCosts(String key) {
        return costs.get(key);
    }

}
