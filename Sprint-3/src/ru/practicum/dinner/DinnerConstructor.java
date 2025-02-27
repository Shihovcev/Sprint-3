package ru.practicum.dinner;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> listDishes;

    void addNewDish(String typeDish, String nameDish) {
        if (menu.containsKey(typeDish)) {               // проверяем есть ли такой тип блюд
            if (menu.get(typeDish).contains(nameDish)) {                // Проверяем есть ли уже такое блюдо в данном типе блюд
                System.out.println("Такое блюдо уже есть");
            } else {
                menu.get(typeDish).add(nameDish); // Добавляем блюдо к существующему списку
            }
        } else {
            listDishes = new ArrayList<>(); // создаем новый тип блюд и добавляем туда блюдо
            listDishes.add(nameDish); // добавляем туда блюдо
            menu.put(typeDish, listDishes); // добавляем в меню тип блюда и само блюдо
        }
    }

    ArrayList<ArrayList<String>> GenerateListDishes(String ... typeDish){
        ArrayList<ArrayList<String>> finishMenu = new ArrayList<>();

        return finishMenu;
    }
}