package project.withoutoop;

import java.io.IOException;
import java.util.*;

public class PersonScanAndSort {

    private static List<Person> persons = new ArrayList<>();
    private static List<Person> notSortedPersons = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void mainMenu() throws IOException {
        while (true) {
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
            System.out.println("Для выхода из программы нажмите 6");
            String choose = in.nextLine();
            switch (choose) {
                case "1":
                    addPerson();
                    continue;
                case "2":
                    for (Person element : notSortedPersons) {
                        System.out.println(element);
                    }
                    continue;
                case "3":
                    PersonLastnameComparator personLastnameComparator = new PersonLastnameComparator();
                    Collections.sort(persons, personLastnameComparator);
                    personLastnameComparator.printSolution(persons);
                    continue;
                case "4":
                    persons.stream().distinct().sorted(Comparator.comparing(Person::getLastName)).forEach(System.out::println);
                    continue;
                case "5":
                    SaveReadFile saveReadFile = new SaveReadFile();
                    saveReadFile.save(notSortedPersons);
                    continue;
                case "6":
                    break;
                default:
                    System.out.println("\nнекорректный ввод\n");
                    continue;
            }
            break;
        }
    }

    private void addPerson() {
        while (true) {
            System.out.print("Введите имя: ");
            String strName = in.nextLine();
            System.out.print("Введите фамилию: ");
            String strSurname = in.nextLine();
            Person person = new Person(strName, strSurname);
            persons.add(person);
            notSortedPersons.add(person);
            // notSortedPersons = persons;
            System.out.print("Желаете ввести еще одного пользователя? (да/нет) ");
            String answer = in.nextLine();
            switch (answer) {
                case "нет":
                case "не":
                case "н":
                case "no":
                case "n":
                    listMenu();
                    break;
                case "да":
                case "д":
                case "yes":
                    continue;
                default:
                    System.out.println("\nнекорректный ввод\n");
                    break;
            }
            break;
        }
    }

    private void listMenu() {
        System.out.println("Для вывода обычного списка нажмите 1");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка нажмите 2");
        System.out.println("-----------------------------------------");
        System.out.println("Для вывода отсортированного списка с уникальными \n значениями нажмите 3");
        System.out.println("-----------------------------------------");
        System.out.println("Для перехода в основное меню нажмите 4");
        String answer2 = in.nextLine();
        switch (answer2) {
            case "1":
                for (Person element : notSortedPersons) {
                    System.out.println(element.toString());
                }
                listMenu();
                break;
            case "2":
                PersonLastnameComparator personLastnameComparator = new PersonLastnameComparator();
                Collections.sort(persons, personLastnameComparator);
                personLastnameComparator.printSolution(persons);
                listMenu();
                break;
            case "3":
                persons.stream().distinct().sorted(Comparator.comparing(Person::getLastName)).forEach(System.out::println);
                listMenu();
                break;
            case "4":
                break;
            default:
                System.out.println("\nнекорректный ввод\n");
                break;
        }
    }
}
