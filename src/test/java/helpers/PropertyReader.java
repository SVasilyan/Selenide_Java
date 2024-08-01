package helpers;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyReader {

    public static Properties constantsProperties = new Properties();

    public static void readPropertyFile(String filepath) {
        try (InputStream is = PropertyReader.class.getClassLoader().getResourceAsStream(filepath)) {
            assert is != null;
            try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                constantsProperties.load(reader);

            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
