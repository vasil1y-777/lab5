package classes.commands;


import classes.DataStorage;
import interfaces.Commandable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClearFile implements Commandable {

    @Override
    public void execute(String... args) {
        File file = new File(DataStorage.STORAGE_FILE_PATH);
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
    }

    @Override
    public String getName() {
        return "clear_file";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tочистить файл коллекции";

    }

    List<String> readEmptyXMLCollection() throws IOException {
        List<String> strs = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(DataStorage.EMPTY_STORAGE_SAMPLE_FILE_PATH));
        String str;
        while ((str = in.readLine()) != null) {
            strs.add(str);
        }
        return strs;
    }

}

