package project.oop;

public class MenuLists {


    public static void menu1() {
        System.out.println("Для добавления пользователя нажмите 1");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода обычного списка нажмите 2");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка нажмите 3");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка с уникальными \n элементами нажмите 4");
        System.out.println("-----------------------------------------");
        System.out.println("Для записи списка в файл нажмите 5");
        System.out.println("-----------------------------------------");
        System.out.println("Для чтения списка из файла нажмите 6");
        System.out.println("-----------------------------------------");
        System.out.println("Для очистки списка людей и файла нажмите 7");
        System.out.println("-----------------------------------------");
        System.out.println("Для выхода из программы нажмите 8");
    }

    public static void question() {
        System.out.println("Желаете ввести еще одного пользователя? (да/нет) ");
    }

    public static void menu2() {
        System.out.println("Для вывода обычного списка нажмите 1");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка нажмите 2");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка с уникальными \n значениями нажмите 3");
        System.out.println("-----------------------------------------");
        System.out.println("Для перехода в основное меню нажмите 4");
    }

    public static void error() {
        System.out.println("\nнекорректный ввод\n");
    }

    public static void typeFirstName() {
        System.out.println("Введите имя: ");
    }

    public static void typeLastName() {
        System.out.println("Введите фамилию: ");
    }

    public static void fileSaved() {
        System.out.println("Файл сохранен");
    }

    public static void clearDataInMemory() {
        System.out.println("Элементы удалены из списка");
        System.out.println("Элементы удалены из файла");
    }

    public static void exit() {
        System.out.println("Выход из приложения");
    }

    public static void next() {
        System.out.println("Люди добавлены в список,\n выберете следующее действие");
    }

}
