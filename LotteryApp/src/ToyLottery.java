import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyLottery {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());
    private Random random = new Random();
    private FileResultWriter resultWriter;

    public ToyLottery(FileResultWriter resultWriter) {
        this.resultWriter = resultWriter;
    }

    public void put(String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        int weight = Integer.parseInt(parts[1]);
        String name = parts[1];

        Toy toy = new Toy(id, name, weight);
        toyQueue.add(toy);
    }

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
