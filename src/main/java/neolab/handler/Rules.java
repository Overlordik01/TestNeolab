package neolab.handler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

public class Rules {

    private final Properties properties = new Properties();

    public Rules(final String URLProperties) throws IOException {
        connectRules(URLProperties);
    }

    private void connectRules(String URL) throws IOException {
        try (InputStream stream = new FileInputStream(new File(URL))) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            properties.load(reader);
        }
    }

    public String getUrl(){
        return properties.getProperty("file.URL");
    }

    public Set<Object> getRules(){
        return properties.keySet();
    }

    public String getAnimalProperty(final String property) {
        return properties.getProperty(property);
    }
}
