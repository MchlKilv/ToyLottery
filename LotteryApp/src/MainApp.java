/**
 * Класс MainApp содержит метод main и является точкой входа в программу.
 */
public class MainApp {
    public static void main(String[] args) {
        // Создание поставщика названий игрушек на основе файла конфигурации
        ToyNameProvider toyNameProvider = new ToyNameProvider("resources/toys_config.properties");
        // Создание объекта для записи результатов в файл с использованием поставщика
        // названий
        FileResultWriter writer = new DefaultFileResultWriter(toyNameProvider);
        // Создание объекта лотереи с игрушками и установка объекта для записи
        // результатов
        ToyLottery toyLottery = new ToyLottery(writer);

        toyLottery.put("1 2 Конструктор");
        toyLottery.put("2 2 Робот");
        toyLottery.put("3 6 Кукла");
        toyLottery.put("4 2 Шашки");
        toyLottery.put("5 2 Книга");
        toyLottery.put("6 6 Мячик");

        // Запись результатов лотереи в файл
        toyLottery.writeToTextFile("LotteryResults.txt", 30);
    }
}
