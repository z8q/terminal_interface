package project.withoutoop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveReadFile {

    public void save(List<Person> list) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(Person element : list) {
            String name = element.getFirstName();
            String lastName = element.getLastName();
            writer.write(name + " " + lastName + System.getProperty("line.separator"));
        }
        writer.close();
    }
    public void read() throws IOException {
        try(FileReader reader = new FileReader("output.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
