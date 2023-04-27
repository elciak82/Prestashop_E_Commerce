package utils.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class JsonMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T readAsDto(String fileName, Class<T> clazz) {
        T dto = null;
        try {
            URL url = getClass().getResource(String.format("/%s", fileName));
            dto = mapper.readValue(new File(Objects.requireNonNull(url).getPath()), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public <T> List<T> readAsDtoList(String fileName, Class<T> clazz) {
        List<T> dtoList = null;
        try {
            URL url = getClass().getResource(String.format("/%s", fileName));
            dtoList = mapper.readValue(new File(Objects.requireNonNull(url).getPath()),
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dtoList;
    }
}
