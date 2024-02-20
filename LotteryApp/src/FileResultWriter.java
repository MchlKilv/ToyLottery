import java.io.FileWriter;
import java.io.IOException;

public interface FileResultWriter {
    void writeToFile(FileWriter writer, int result) throws IOException;
}
