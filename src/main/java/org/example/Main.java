package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем HashMap для хранения записей в телефонной книге
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу (пример данных)
        addContact(phoneBook, "Иванов", "111-111");
        addContact(phoneBook, "Петров", "222-222");
        addContact(phoneBook, "Сидоров", "333-333");
        addContact(phoneBook, "Иванов", "444-444");
        addContact(phoneBook, "Петров", "555-555");
        addContact(phoneBook, "Сидоров", "666-666");

        // Выводим телефонную книгу, отсортированную по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт с таким именем уже существует, добавляем телефон к существующему списку
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей, сортируем его по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        // Выводим отсортированные записи
        for (int i = sortedEntries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = sortedEntries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}