import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс ToyNameProvider предоставляет названия игрушек на основе уникальных
 * идентификаторов.
 */
public class ToyNameProvider {
    private Map<Integer, String> toyNames;

    /**
     * Конструктор класса ToyNameProvider.
     *
     * @param configFile Путь к файлу конфигурации с соответствиями id и названий
     *                   игрушек.
     */
    public ToyNameProvider(String configFile) {
        this.toyNames = loadToyNames(configFile);
    }

    /**
     * Метод loadToyNames загружает соответствия id и названий игрушек из файла
     * конфигурации.
     *
     * @param configFile Путь к файлу конфигурации с соответствиями id и названий
     *                   игрушек.
     * @return Карта с соответствиями id и названий игрушек.
     */
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

    /**
     * Метод getToyName возвращает название игрушки по её уникальному
     * идентификатору.
     *
     * @param result Уникальный идентификатор игрушки.
     * @return Название игрушки или "Неизвестная игрушка", если идентификатор не
     *         найден.
     */
    public String getToyName(int result) {
        return toyNames.getOrDefault(result, "Неизвестная игрушка");
    }

}
