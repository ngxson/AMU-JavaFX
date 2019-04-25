package ngxson.nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ngxson.utils.Document;
import ngxson.utils.LocalDateDeserializer;
import ngxson.utils.LocalDateTimeDeserializer;

import javax.print.Doc;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataFetcher {
    public static final String API_KEY = "jqAGvNAwUIBu4fl9FSOjdm3V4F7hIglRzI6pdX9d";
    public static final String API_PROTOCOL = "https";
    public static final String API_DOMAIN = "api.nasa.gov";
    public static final String API_SERVICE = "/neo/rest/v1/neo/browse";

    public static ObjectMapper mapper = new ObjectMapper();

    public DataFetcher() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);
    }

    private String prepareQuery(int page) {
        return String.format("api_key=%s&page=%d", API_KEY, page);
    }

    private URI prepareURI(String request) throws URISyntaxException {
        return new URI(
                API_PROTOCOL,
                API_DOMAIN,
                API_SERVICE,
                request,
                null
        );
    }

    public void fetchToOutputStream(OutputStream outputStream, int page) throws URISyntaxException, IOException {
        String request = prepareQuery(page);
        URI uri = prepareURI(request);
        URL url = uri.toURL();

        InputStream inputStream = url.openStream();
        inputStream.transferTo(outputStream);
    }

    public Document fetch(int page) throws URISyntaxException, IOException {
        String request = prepareQuery(page);
        URI uri = prepareURI(request);
        URL url = uri.toURL();

        return mapper.readValue(url, Document.class);
    }
}
