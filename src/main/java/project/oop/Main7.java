package project.oop;

import project.withoutoop.Person;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) throws Exception {
        List<Person> personOopList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
    }

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        // Наименование пункта меню
        private String name;
        // Доступное действие
        private Exec exec;

        public String getName() {
            return name;
        }
        public Exec getExec() {
            return exec;
        }
    }

    private static class Menu {

        private List<MenuItem> items = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        Service service = new Service();
        MenuLists menuLists = new MenuLists();

        public Menu(Scanner scan) throws Exception {
            menuLists.menu1();

            MenuItem menuItem = new MenuItem();
            menuItem.name = "1";
            menuItem.exec =  x -> service.addPerson();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "2";
            menuItem.exec = x -> service.showList();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "3";
            menuItem.exec = x -> service.showSortList();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "4";
            menuItem.exec = x -> service.showSortListWithUniqueValues();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "5";
            menuItem.exec = x -> service.saveToFile();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "6";
            menuItem.exec = x -> service.readFromFile();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "7";
            menuItem.exec = x -> service.clearDataInMemory();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "8";
            menuItem.exec = x -> service.exit();
            items.add(menuItem);

            while (true) {
                int i = 0;
                String s = scan.nextLine();
                for (MenuItem item : items) {
                    if (item.getName().equals(s)) {
                        i = 1;
                        item.exec.exec(personList);
                        break;
                    }
                }
                if (i == 0) {
                    System.out.println("Ошибка ввода, повторите выбор");
                }
                if (false) {
                    break;
                }
            }
        }
    }

}
