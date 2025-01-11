package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.JsonFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonTest {
    private final ClassLoader cl = JsonTest.class.getClassLoader();

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void checkJsonFileTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Json.json")) {
            assert is != null;
            try (InputStreamReader isr = new InputStreamReader(is)) {
                JsonFile data;
                data = objectMapper.readValue(isr, JsonFile.class);
                Assertions.assertEquals(123,data.getProfile().getId());
                Assertions.assertEquals("Amos", data.getProfile().getName());
                Assertions.assertEquals("Jim", data.getFriends().get(0).getName());
                Assertions.assertEquals("Alex", data.getFriends().get(1).getName());
            }
        }
    }
}