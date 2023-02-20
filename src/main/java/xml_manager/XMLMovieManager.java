package xml_manager;

import model.Movies;

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


    private final static String BASE_PATH_STORAGE = "src/main/java/data_storage/";

    private final static String XML = ".xml";
    private static XMLMovieManager INSTANCE;
    private final Class BASE_CLASS = Movies.class;


    private XMLMovieManager() {
    }

    public static XMLMovieManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new XMLMovieManager();
        }

        return INSTANCE;
    }

    public Movies readObjectFromXML(String filename) {
        Movies movies = null;
        try {
            JAXBContext context = JAXBContext.newInstance(BASE_CLASS);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

            movies = (Movies) jaxbUnmarshaller.unmarshal(new File(BASE_PATH_STORAGE + filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return movies;
    }


    public void saveObjectToXML(Movies movies, String filename) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(BASE_CLASS);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String filepath = BASE_PATH_STORAGE + filename;
            File f = new File(filepath);
            try {
                File myObj = new File(filepath);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("Founded a file....");
                    Movies mmm = new Movies();
                    StringWriter sw = new StringWriter();
                    jaxbMarshaller.marshal(movies, sw);
                    String xmlString = sw.toString();
                    System.out.println(xmlString);
                    sw.close();

                    PrintWriter writer = new PrintWriter(filepath);
                    writer.print(sw);
                    writer.close();
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not found error");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An IO error occurred.");
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public void saveObjectToXML(Movies movies) {
        JAXBContext jaxbContext;
        String filename = "trash_can.xml";
        try {
            jaxbContext = JAXBContext.newInstance(BASE_CLASS);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String filepath = BASE_PATH_STORAGE + filename;
            File f = new File(filepath);
            try {
                File myObj = new File(filepath);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("Founded a file....");
                    Movies mmm = new Movies();
                    StringWriter sw = new StringWriter();
                    jaxbMarshaller.marshal(movies, sw);
                    String xmlString = sw.toString();
                    System.out.println(xmlString);
                    sw.close();

                    PrintWriter writer = new PrintWriter(filepath);
                    writer.print(sw);
                    writer.close();
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not found error");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An IO error occurred.");
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
