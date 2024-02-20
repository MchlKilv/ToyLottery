import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс DefaultFileResultWriter реализует интерфейс FileResultWriter и отвечает
 * за запись результата в файл.
 */
public class DefaultFileResultWriter implements FileResultWriter {
    private ToyNameProvider nameProvider; // Поставщик названий игрушек для получения информации по их идентификаторам.

    /**
     * Конструктор класса DefaultFileResultWriter.
     *
     * @param nameProvider Поставщик названий игрушек для получения информации по их
     *                     идентификаторам.
     */
    public DefaultFileResultWriter(ToyNameProvider nameProvider) {
        this.nameProvider = nameProvider;
    }

    /**
     * Метод writeToFile записывает информацию о выпавшей игрушке в файл.
     *
     * @param writer Объект FileWriter для записи в файл.
     * @param result Результат (идентификатор игрушки), который нужно записать в
     *               файл.
     * @throws IOException Исключение, которое может возникнуть при работе с файлом.
     */
    @Override
    public void writeToFile(FileWriter writer, int result) throws IOException {
        // Получаем название игрушки по идентификатору
        String toyName = nameProvider.getToyName(result);

        // Формируем сообщение о выпавшей игрушке
        String message = String.format("Выпала игрушка с id %d: %s", result, toyName);

        // Записываем сообщение в файл и добавляем символ новой строки
        writer.write(message + "\n");
    }

}
