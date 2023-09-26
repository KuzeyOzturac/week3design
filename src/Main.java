import okhttp3.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String baseUrl = "https://webservices.umoiq.com/service/publicXMLFeed";

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Constructs set of parameters to be passed to the URL
        Map<String, String> params = new HashMap<>();
        params.put("command", "vehicleLocations");
        params.put("a", "ttc");
        params.put("r", "510");

        // Builds the URL with the parameters
        HttpUrl.Builder httpBuilder = HttpUrl.parse(baseUrl).newBuilder();
        if (params != null) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        String url = httpBuilder.build().toString();

        // Builds the request
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            // Executes the request
            Response response = client.newCall(request).execute();

            // Converts the response to XML
            Document doc = convertStringToXMLDocument(response.body().string());

            // Normalizes the XML response
            doc.getDocumentElement().normalize();

            // Prints the XML response
            System.out.println("TTC Route 510 Vehicle Locations");
            System.out.println("------");

            NodeList nodeList = doc.getElementsByTagName("vehicle");

            // Prints the vehicle id and location
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                System.out.println("\tVehicle id: " + element.getAttribute("id"));
                System.out.println("\tVehicle location: " + element.getAttribute("lat") + ", " +
                        element.getAttribute("lon") + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
