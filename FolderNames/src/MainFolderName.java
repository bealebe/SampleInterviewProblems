import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 * Created by bryanbeale on 10/18/17.
 */
@SuppressWarnings("Since15")
public class MainFolderName {

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        List<String> col = new ArrayList<String>();

        InputStream is = new ByteArrayInputStream(xml.getBytes());

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(is);

        while(reader.hasNext()){
            XMLEvent e =  reader.nextEvent();
            if(e.isStartElement()) {
                Iterator<Attribute> attrs = e.asStartElement().getAttributes();

                while (attrs.hasNext()) {
                    Attribute a = attrs.next();
                    if (a.getValue().toString().charAt(0) == startingLetter) {
                        col.add(a.getValue().toString());
                    }
                }
            }
        }




        return col;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
