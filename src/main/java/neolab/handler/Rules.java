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
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
        stream = new FileInputStream(new File(URL));
        reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        properties.load(reader);
        } finally {
            stream.close();
            if (reader != null) {
                reader.close();
            }
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
