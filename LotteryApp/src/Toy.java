/**
 * Класс Toy представляет игрушку с уникальным идентификатором, названием и
 * весом (частотой выпадения).
 */

public class Toy {
    private int id; // Уникальный идентификатор игрушки.
    private String name; // Название игрушки.
    private int weight; // Вес игрушки (частота выпадения).

    /**
     * Конструктор класса Toy.
     *
     * @param id     Уникальный идентификатор игрушки.
     * @param name   Название игрушки.
     * @param weight Вес игрушки (частота выпадения).
     */
    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    /**
     * Получить уникальный идентификатор игрушки.
     *
     * @return Уникальный идентификатор игрушки.
     */
    public int getId() {
        return id;
    }

    /**
     * Получить название игрушки.
     *
     * @return Название игрушки.
     */
    public String getName() {
        return name;
    }

    /**
     * Получить вес игрушки (частоту выпадения).
     *
     * @return Вес игрушки.
     */
    public int getWeight() {
        return weight;
    }
}
