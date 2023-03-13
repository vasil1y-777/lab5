package classes.xml_manager;

import classes.DataStorage;
import classes.movie.Movies;
import exceptions.DangerException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;


/**
 * Model of XML manager. Sub-model of the <code>Route</code>. Singleton to read-write of some class.
 * Some fields have restrictions. It's signed under every method of field.
 */
public class XMLMovieManager {
    /*
    TODO чтение xml файлов можно без Scanner ++
    TODO запись в файлы реализовать с помощью PrintWriter ++
    TODO добавить итераторы ??
     */


    private static XMLMovieManager INSTANCE;
    private final Class BASE_CLASS = Movies.class;

    private XMLMovieManager() {
    }

    public static XMLMovieManager getInstance() {
        return INSTANCE != null ? INSTANCE : new XMLMovieManager();
    }

    public Movies readCollectionFromXML() {
        Movies movies = null;
        try {
            JAXBContext context = JAXBContext.newInstance(BASE_CLASS);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            movies = (Movies) jaxbUnmarshaller.unmarshal(new File(DataStorage.STORAGE_FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void saveCollectionToXML(Movies movies) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(BASE_CLASS);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File(DataStorage.STORAGE_FILE_PATH);
            file.createNewFile(); // checks existence of file and create if necessary
            Movies mmm = new Movies();
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(movies, sw);
            String xmlString = sw.toString();
            sw.close();

            PrintWriter writer = new PrintWriter(DataStorage.STORAGE_FILE_PATH);
            writer.print(sw);
            writer.close();

        } catch (FileNotFoundException e) {
            new DangerException("Файл не найден").printMessage();
        } catch (IOException e) {
            new DangerException("Ошибка ввода-вывода").printMessage();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
