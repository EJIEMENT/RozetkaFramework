package manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.ProductModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JacksonReader {
    public static ProductModel readDataFromXml(String filePath) {
        XmlMapper xmlMapper = new XmlMapper();
        ProductModel value = null;
        try {
            String readContent = new String(Files.readAllBytes(Paths.get(filePath)));
            value = xmlMapper.readValue(readContent, ProductModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static List<ProductModel> readListDataFromXml(String filePath) {
        XmlMapper xmlMapper = new XmlMapper();
        List<ProductModel> value = null;
        try {
            String readContent = new String(Files.readAllBytes(Paths.get(filePath)));
            value = xmlMapper.readValue(readContent, new TypeReference<List<ProductModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
