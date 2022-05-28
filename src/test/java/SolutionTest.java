import creature.Creature;
import creature.CreatureCreator;
import org.junit.Test;
import reader.SettingsReader;
import reader.SettingsReaderFromFile;

import static org.junit.Assert.*;

public class SolutionTest {

    SettingsReader reader = new SettingsReaderFromFile("src/main/resources/settings.json");

    @Test
    public void solutionHumanTest() {
        String map = "P".repeat(16);
        String race = "Human";
        int shortestDistance = 6;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }

    @Test
    public void solutionHumanTest2() {
        String map = "S".repeat(16);
        String race = "Human";
        int shortestDistance = 30;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionHumanTest3() {
        String map = "TPWSWPPTTWPPSSTP";
        String race = "Human";
        int shortestDistance = 6;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionHumanTest4() {
        String map = "STWSWTPPTPTTPWPP";
        String race = "Human";
        int shortestDistance = 10;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }

    @Test
    public void solutionSwamperTest() {
        String map = "T".repeat(16);
        String race = "Swamper";
        int shortestDistance = 30;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionSwamperTest2() {
        String map = "P".repeat(16);
        String race = "Swamper";
        int shortestDistance = 12;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionSwamperTest3() {
        String map = "TPWSWPPTTWPPSSTP";
        String race = "Swamper";
        int shortestDistance = 12;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionWoodmanTest() {
        String map = "T".repeat(16);
        String race = "Woodman";
        int shortestDistance = 12;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionWoodmanTest2() {
        String map = "S".repeat(16);
        String race = "Woodman";
        int shortestDistance = 18;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }


    @Test
    public void solutionWoodmanTest3() {
        String map = "TPWSWPPTTWPPSSTP";
        String race = "Woodman";
        int shortestDistance = 12;
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals(Solution.getResult(creature, map), shortestDistance);
    }



    @Test
    public void transformMapToGraphMatrixSizeAssertionTest() {
        String race = "Woodman";
        Creature creature = CreatureCreator.create(reader, race);
        assertEquals("Length of array is incorrect", Solution.transformMapToGraphMatrix("STWSWTPPTPTTPWPP", creature).length, 16);
        assertEquals("Length of array is incorrect", Solution.transformMapToGraphMatrix("STWSWTPPTPTTPWPP", creature)[1].length, 16);
    }
    @Test
    public void transformMapToGraphMatrixIllegalArgumentTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Solution.transformMapToGraphMatrix("SSTWSWTPPTPTTPWPP", null);
        });
        String expectedMessage = "The map is not 4*4";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void transformMapToGraphMatrixWrongMapTest() {
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            Solution.transformMapToGraphMatrix("0TWSWTPPTPTTPWPP", null);
        });
        String expectedMessage = "Map contains not predefined designations";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
