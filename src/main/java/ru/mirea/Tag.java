package ru.mirea;

// Класс, описывающий тэг
public class Tag {

    // Поля класса
    // Мнемоника
    private String mnemo;
    // Имя
    private String name;

    // Конструктор с параметрами
    public Tag(String mnemo, String name) {
        this.mnemo = mnemo;
        this.name = name;
    }

    // Получение мнемоники
    public String getMnemo() {
        return mnemo;
    }

    // Изменение мнемоники
    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    // Изменение имя
    public void setName(String name) {
        this.name = name;
    }

    // Получение имя
    public String getName() {
        return name;
    }
}
