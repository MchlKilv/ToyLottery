import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ToyNameProvider {
    private Map<Integer, String> toyNames;

    public ToyNameProvider(String configFile) {
        this.toyNames = loadToyNames(configFile);
    }

    private Map<Integer, String> loadToyNames(String configFile) {
        Map<Integer, String> toyNames = new HashMap<>();
        Properties properties = new Properties();

        try (FileReader reader = new FileReader(configFile)) {
            properties.load(reader);

            for (String key : properties.stringPropertyNames()) {
                int id = Integer.parseInt(key);
                String name = properties.getProperty(key);
                toyNames.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок
        }

        return toyNames;
    }

    public String getToyName(int result) {
        return toyNames.getOrDefault(result, "Неизвестная игрушка");
    }

}
