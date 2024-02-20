import java.io.FileWriter;
import java.io.IOException;

/**
 * Интерфейс FileResultWriter определяет метод для записи результата в файл.
 */
public interface FileResultWriter {

    /**
     * Метод writeToFile записывает переданный результат в файл, используя
     * FileWriter.
     *
     * @param writer Объект FileWriter для записи в файл.
     * @param result Результат, который нужно записать в файл.
     * @throws IOException Исключение, которое может возникнуть при работе с файлом.
     */
    void writeToFile(FileWriter writer, int result) throws IOException;
}
