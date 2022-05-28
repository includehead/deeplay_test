package reader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of SettingsReader to read settings from file.
 */
public class SettingsReaderFromFile implements SettingsReader {

    String path;

    public SettingsReaderFromFile(final String path) {
        this.path = path;
    }

    @Override
    public Map<String, HashMap<String, Integer>> read() {
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader(path))) {

            return gson.fromJson(reader, new TypeToken<Map<String, HashMap<String, Integer>>>() {}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
