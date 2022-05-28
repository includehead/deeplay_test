package reader;


import java.util.HashMap;
import java.util.Map;
/**
 * Interface to read settings.
 */
public interface SettingsReader {
    Map<String, HashMap<String, Integer>> read();
}
