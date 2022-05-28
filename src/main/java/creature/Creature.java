package creature;

import java.util.Map;

public class Creature {

    /**
     * Class represents creature.
     * Map: contains links between fields and their costs.
     * Key: field's name.
     * Value: field's cost.
     */
    private final Map<String, Integer> costs;
    Creature(final Map<String, Integer> costs) {
        this.costs = costs;
    }

    public int getCosts(final String key) {
        return costs.get(key);
    }

}
