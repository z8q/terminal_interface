import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class PersonLastnameComparator implements Comparator<Person> {

    public int compare(Person a, Person b) {

        return a.getLastName().compareTo(b.getLastName());
    }

    public void printSolution(List<Person> arrayForSolution) {

        for(Person element : arrayForSolution) {
            System.out.println(element.toString());
        }
    }
}