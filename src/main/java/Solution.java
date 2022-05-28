import creature.Creature;

public class Solution {

    public static int getResult(final Creature creature, final String map) {
        return findShortestWay(map, creature);
    }

    /**
     * Finds the shortest way through the map.
     * @param map contains symbolic representation of the map to find the shortest way in.
     * @param creature contains the creature.
     *
     * linkMatrix - graph representation of map.
     * vertices - vertices that was visited.
     * shortestPath - the shortest path to each vertex.
     *
     * @return the shortest way for the creature through the map.
     */
    static int findShortestWay(final String map, final Creature creature) {

        final int[][] linkMatrix = transformMapToGraphMatrix(map, creature);
        int size = linkMatrix.length;
        int[] shortestPath = new int[size];
        int[] vertices = new int[size];
        int temp;
        int minIndex;
        int min;
        int beginIndex = 0;
        int unreachableValue = Integer.MAX_VALUE;

//        initialising
        for (int i = 0; i < size; i++) {
            shortestPath[i] = unreachableValue;
            vertices[i] = 1;
        }
        shortestPath[beginIndex] = 0;

//        walk through each vertex and find the shortest path to
        do {
            min = unreachableValue;
            minIndex = unreachableValue;
//            If there is no path shorter, mixIndex won't be reassigned.
            for (int i = 0; i < size; i++) {
                if (vertices[i] == 1 && shortestPath[i] < min) {
                    min = shortestPath[i];
                    minIndex = i;
                }
            }

            if (minIndex != unreachableValue) {
                for (int i = 0; i < size; i++) {
                    if (linkMatrix[minIndex][i] > 0) {
                        temp = min + linkMatrix[minIndex][i];
                        if (temp < shortestPath[i]) {
                            shortestPath[i] = temp;
                        }
                    }
                }
                vertices[minIndex] = 0;
            }
//        if all shortest paths were found, exit loop
        } while (minIndex < unreachableValue);

        return shortestPath[size - 1];
    }

    /**
     * Function transform map to graph matrix that contains connections between cells.
     *
     * @param map contains map to find the shortest way through
     * @param creature the actual creature to whom will be found a way
     * @return 16*16 matrix
     */
    static int[][] transformMapToGraphMatrix(final String map, final Creature creature) {

        final int mapSize = 4;

        if (map.length() != 16) {
            throw new IllegalArgumentException("The map is not 4*4");
        }

        final int[][] linkMatrix = new int[map.length()][map.length()];

        final int[] mapWithNumbers = new int[map.length()];

        try {
            for (int i = 0; i < map.length(); i++) {
                mapWithNumbers[i] = creature.getCosts(String.valueOf(map.charAt(i)));
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Map contains not predefined designations");
        }

        for (int i = 0; i < map.length(); i++) {
            for (int j = 0; j < map.length(); j++) {
                if (i - j == 1 && i % mapSize != 0) {
                    linkMatrix[i][j] = mapWithNumbers[i];
                } else if (i - j == mapSize) {
                    linkMatrix[i][j] = mapWithNumbers[i];
                } else if (j - i == 1 && j % mapSize != 0) {
                    linkMatrix[i][j] = mapWithNumbers[j];
                } else if (j - i == mapSize) {
                    linkMatrix[i][j] = mapWithNumbers[j];
                }
            }
        }
        return linkMatrix;
    }
}


