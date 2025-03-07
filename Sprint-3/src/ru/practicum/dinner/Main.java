package ru.practicum.dinner;


import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    exit();
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType,dishName);    // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos;
        try {
            int number = scanner.nextInt();
            numberOfCombos = number;
        } catch (Exception e) {
            System.out.println("Ошибка ввода, введите целое число... \n");
            return;
        }
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> menu = new ArrayList<>();
        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            menu.add(nextItem);
            nextItem = scanner.nextLine();

        }
        // сгенерируйте комбинации блюд и выведите на экран
        dc.GenerateListDishes(menu, numberOfCombos);

    }

    private static void exit(){
        System.out.println("Вы уверенны что хотите выйти? Да / Нет");
        String exit = scanner.nextLine();
        if (exit.equals("Да")){
            System.exit(0);
        }else{
            printMenu();
        }
    }

}