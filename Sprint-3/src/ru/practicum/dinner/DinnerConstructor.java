package ru.practicum.dinner;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> listDishes;

    void addNewDish(String typeDish, String nameDish) {
        if (menu.containsKey(typeDish)) {               // проверяем есть ли такой тип блюд
            if (menu.get(typeDish).contains(nameDish)) {         // Проверяем есть ли уже такое блюдо в данном типе блюд
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

    void GenerateListDishes(ArrayList<String> typeDish, int numberOfCombos){
        Random random = new Random();
        for (int i = 0; i < numberOfCombos; i++) { // Считаем сколько комлектов должно быть
            System.out.println("Комбо " + (i + 1));
            String combo = "";

            for(String dishType : typeDish){
                if (menu.containsKey(dishType)) { // Проверяем, существует ли такой тип блюда в меню
                    ArrayList<String> dishes = menu.get(dishType); // Получаем список блюд для данного типа
                    int rand = random.nextInt(dishes.size()); // Генерируем случайный индекс
                    String selectedDish = dishes.get(rand); // Выбираем случайное блюдо
                    combo += selectedDish + " "; // Добавляем его в комбинацию
                } else {
                    System.out.println("Тип блюда '" + dishType + "' не найден в меню.");
                }
            }
            System.out.println(combo);
        }
    }


}

