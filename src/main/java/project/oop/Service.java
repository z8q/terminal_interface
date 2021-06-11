package project.oop;

import project.withoutoop.Person;
import project.withoutoop.PersonLastnameComparator;
import project.withoutoop.SaveReadFile;

import java.io.IOException;
import java.util.*;

public class Service {

    Scanner in = new Scanner(System.in);
    private List<Person> persons = new ArrayList<>();
    private List<Person> notSortedPersons = new ArrayList<>();
    private List<Person> emptyList = new ArrayList<>();
    MenuLists menuLists = new MenuLists();

    public void addPerson() {

        while (true) {
            menuLists.typeFirstName();
            String strName = in.nextLine();
            menuLists.typeLastName();
            String strSurname = in.nextLine();
            Person person = new Person(strName, strSurname);
            persons.add(person);
            notSortedPersons.add(person);
            // notSortedPersons = persons;
            menuLists.question();
            String answer = in.nextLine();
            switch (answer) {
                case "нет":
                case "не":
                case "н":
                case "no":
                case "n":
                    menuLists.next();
                    break;
                case "да":
                case "д":
                case "yes":
                    continue;
                default:
                    menuLists.error();
                    break;
            }
            break;
        }

    }
    public void showList() {
        for (Person element : notSortedPersons) {
            System.out.println(element);
        }
    }
    public void showSortList() {
        PersonLastnameComparator personLastnameComparator = new PersonLastnameComparator();
        Collections.sort(persons, personLastnameComparator);
        personLastnameComparator.printSolution(persons);

    }
    public void showSortListWithUniqueValues() {
        persons.stream().distinct().sorted(Comparator.comparing(Person::getLastName)).forEach(System.out::println);
    }
    public void saveToFile() {
        SaveReadFile saveReadFile = new SaveReadFile();
        try {
            saveReadFile.save(notSortedPersons);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuLists.fileSaved();
    }
    public void readFromFile() {
        SaveReadFile saveReadFile = new SaveReadFile();
        try {
            saveReadFile.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clearDataInMemory() {
        persons.clear();
        SaveReadFile saveReadFile = new SaveReadFile();
        try {
            saveReadFile.save(emptyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuLists.clearDataInMemory();
    }

    public void exit() {
        MenuLists.exit();
        System.exit(0);
    }
}
