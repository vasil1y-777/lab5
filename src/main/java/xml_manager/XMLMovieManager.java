package xml_manager;

import DataStorage;
import movie.Movies;

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
    private static XMLMovieManager INSTANCE;
    private final Class BASE_CLASS = Movies.class;

    private XMLMovieManager() {
    }

    public static XMLMovieManager getInstance() {
        return INSTANCE != null ? INSTANCE : new XMLMovieManager();
    }

    public Movies readObjectFromXML(String filename) {
        Movies movies = null;
        try {
            JAXBContext context = JAXBContext.newInstance(BASE_CLASS);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            movies = (Movies) jaxbUnmarshaller.unmarshal(new File(DataStorage.BASE_PATH_STORAGE + filename));
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

            String filepath = DataStorage.BASE_PATH_STORAGE + filename;
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
                System.out.println("File not found error");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An IO error occurred");
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

            String filepath = DataStorage.BASE_PATH_STORAGE + filename;
            File f = new File(filepath);
            try {
                File myObj = new File(filepath);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("Founded a file...");
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
                System.out.println("File not found error");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An IO error occurred");
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
