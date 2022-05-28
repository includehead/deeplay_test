package creature;

import reader.SettingsReader;

import java.util.Map;

public class CreatureCreator {

    /**
     * Validates read settings and creates an instance of creature.
     * @param reader contain SettingsReader that provides settings
     * @param race contains race of Creature
     * @return Creature
     */
    public static Creature create (SettingsReader reader, String race) {

        if ("".equals(race)) {
            throw new IllegalArgumentException("Race is not provided.");
        }

        Map<String, Integer> map = reader.read().get(race);

        if (map == null) {
            throw new IllegalArgumentException("There is no such a race.");
        }

        Integer[] values = map.values().toArray(new Integer[0]);

        for (Integer col: values) {
            if (col < 0) {
                throw new IllegalArgumentException("Wrong setting (path should not be negative");
            }
        }

        return new Creature(map);

    }
}
