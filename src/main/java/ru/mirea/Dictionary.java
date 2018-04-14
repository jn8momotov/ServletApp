package ru.mirea;

import java.util.ArrayList;

// Класс для работы со списком
public class Dictionary {

    // Поля класса
    // Список
    private final ArrayList<Tag> listTags;
    // Максимальная длина списка
    private final int lengthList;

    // Конструктор
    public Dictionary(int lengthList) {
        listTags = new ArrayList<Tag>();
        this.lengthList = lengthList;
    }

    // Метод возвращающий список
    public ArrayList<Tag> getListTags() {
        return listTags;
    }

    // Метод изменяющий имя тэга или добавляющий новый тэг в список, если такого еще нет
    public ArrayList<Tag> putTag(String mnemo, String newName) {
        for (Tag tag : listTags) {
            if (tag.getMnemo().equals(mnemo)) {
                tag.setName(newName);
                return listTags;
            }
        }
        if (listTags.size() < lengthList) listTags.add(new Tag(mnemo, newName));
        return listTags;
    }

    // Метод удаляющий тэг по мнемонике
    public ArrayList<Tag> deleteTag(String mnemo) {
        for (Tag tag : listTags) {
            if (tag.getMnemo().equals(mnemo)) {
                listTags.remove(tag);
                return listTags;
            }
        }
        return listTags;
    }

    // Метод поиска тэга в списке
    public ArrayList<Tag> searchTag(String searchMnemo) {
        if (searchMnemo.length() >= 2) {
            ArrayList<Tag> list = new ArrayList<Tag>();
            for (Tag tag : listTags) {
                if (tag.getMnemo().startsWith(searchMnemo))
                    list.add(tag);
            }
            return list;
        }
        else return listTags;
    }

}