import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Класс ToyLottery представляет лотерею с игрушками, где каждая игрушка имеет
 * вес (частоту выпадения).
 */
public class ToyLottery {
    // Приоритетная очередь для хранения игрушек с учетом их веса
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());

    // Генератор случайных чисел для выбора игрушек с учетом веса
    private Random random = new Random();

    // Объект для записи результатов в файл
    private FileResultWriter resultWriter;

    /**
     * Конструктор класса ToyLottery.
     *
     * @param resultWriter Объект для записи результатов в файл.
     */
    public ToyLottery(FileResultWriter resultWriter) {
        this.resultWriter = resultWriter;
    }

    /**
     * Метод put добавляет новую игрушку в лотерею на основе входной строки.
     *
     * @param input Строка, содержащая информацию об игрушке (id, вес, название).
     */
    public void put(String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        int weight = Integer.parseInt(parts[1]);
        String name = parts[2];

        Toy toy = new Toy(id, name, weight);
        toyQueue.add(toy);
    }

    /**
     * Метод get возвращает id случайно выбранной игрушки с учетом их веса.
     *
     * @return Уникальный идентификатор выбранной игрушки.
     */
    public int get() {
        int totalWeight = toyQueue.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = random.nextInt(totalWeight) + 1;

        int cumulativeWeight = 0;
        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                return toy.getId();
            }
        }
        return toyQueue.peek().getId();
    }

    /**
     * Метод writeToTextFile записывает результаты выбора игрушек в файл.
     *
     * @param filename   Имя файла для записи результатов.
     * @param numResults Количество результатов для записи.
     */
    public void writeToTextFile(String filename, int numResults) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < numResults; i++) {
                int result = get();
                resultWriter.writeToFile(writer, result);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
