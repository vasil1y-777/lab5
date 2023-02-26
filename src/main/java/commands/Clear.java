package commands;



import interfaces.Command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clear implements Command {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(COLOR_GREEN + "Enter a collection name: " + COLOR_RESET);
        ColorTextBuilder.printConsoleLine();
        String collectionName = scanner.nextLine();
        String filepath = DataStorage.BASE_PATH_STORAGE + collectionName;
        File file = new File(filepath);
        if (file.exists() && !collectionName.equals("new_file_sample.xml")) {
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.print("");

                for (String line : readEmptyXMLCollection()) {
                    writer.print(line + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (collectionName.equals("new_file_sample.xml")) {
            System.out.println("Нельзя использовать этот файл так как он системный");
        } else {
            System.out.println("Файла с таким именем не существует в хранилище коллекций. " +
                    "\nПроверьте наличие '.xml'");
        }
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tочистить коллекцию";

    }

    List<String> readEmptyXMLCollection() throws IOException {
        List<String> strs = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(DataStorage.BASE_PATH_STORAGE + "new_file_sample.xml"));
        String str;
        while ((str = in.readLine()) != null) {
            strs.add(str);
        }
        return strs;
    }

}