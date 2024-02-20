
public class MainApp {
    public static void main(String[] args) {
        ToyNameProvider toyNameProvider = new ToyNameProvider("resources/toys_config.properties");
        FileResultWriter writer = new DefaultFileResultWriter(toyNameProvider);
        ToyLottery toyLottery = new ToyLottery(writer);

        toyLottery.put("1 2 Конструктор");
        toyLottery.put("2 2 Робот");
        toyLottery.put("3 6 Кукла");

        toyLottery.put("4 2 Шашки");
        toyLottery.put("5 2 Книга");
        toyLottery.put("6 6 Мячик");

        toyLottery.writeToTextFile("LotteryResults.txt", 30);
    }
}
