import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveFile {

    public void save(List<Person> list) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(Person element : list) {
            String name = element.getFirstName();
            String lastName = element.getLastName();
            writer.write(name + " " + lastName + System.getProperty("line.separator"));
        }
        writer.close();
    }
}
