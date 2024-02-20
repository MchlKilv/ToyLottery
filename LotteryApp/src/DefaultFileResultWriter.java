import java.io.FileWriter;
import java.io.IOException;

public class DefaultFileResultWriter implements FileResultWriter {
    private ToyNameProvider nameProvider;

    public DefaultFileResultWriter(ToyNameProvider nameProvider) {
        this.nameProvider = nameProvider;
    }

    @Override
    public void writeToFile(FileWriter writer, int result) throws IOException {
        String toyName = nameProvider.getToyName(result);
        String message = String.format("Выпала игрушка с id %d: %s", result, toyName);
        writer.write(message + "\n");
    }

}
