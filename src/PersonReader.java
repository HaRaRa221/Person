import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String str = "";
        ArrayList<String> crowd = new ArrayList<>();
        ArrayList<Person> Mpeople = new ArrayList<>();
        char DQ = '\u0022';

        final int FIELD_LENGTH = 5;

        String id="", f="", l="", t="";
        int YoB = 0;


        try {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    crowd.add(rec);
                    line++;

                }
                reader.close();

                String[] bounds;
                for (String person : crowd) {
                    bounds = person.split(",");
                    if (bounds.length == FIELD_LENGTH) {

                        id = bounds[0].trim();
                        f = bounds[1].trim();
                        l = bounds[2].trim();
                        t = bounds[3].trim();
                        YoB = Integer.parseInt(bounds[4].trim());
                        Mpeople.add(new Person(id, f, l, t, YoB));


                    } else {
                        System.out.println("Choose a file or fail to process");
                        System.out.println("Required restart of program");
                        System.exit(0);
                    }
                }
            }
            else
            {
                System.out.println("Corrupt file straight ahead: ");
                System.out.println();
            }
            for (Person m: Mpeople) {
                System.out.println(m.toCSVRecord());
            }
            System.out.println();
            System.out.println("<Person>");
            for (Person m: Mpeople){
                System.out.println(m.toXMLRecord());
            }
            System.out.println("</Person>");
            System.out.println();

            System.out.println("{" + DQ + "Person" + DQ + ":[");
            for(Person m: Mpeople) {
                System.out.println(m.toJSONRecord());
            }
            System.out.println("]}");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
