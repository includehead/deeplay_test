import creature.Creature;
import creature.CreatureCreator;
import reader.SettingsReader;
import reader.SettingsReaderFromFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String map = scanner.nextLine();
        String race = scanner.next();

        SettingsReader reader = new SettingsReaderFromFile("src/main/resources/settings.json");

        Creature creature = CreatureCreator.create(reader, race);

        System.out.println(Solution.getResult(creature, map));

    }
}