package manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties prop;
    private static ConfigManager instance;

    private ConfigManager() {
        prop = new Properties();
        loadConfigFile();
    }

    public static ConfigManager getInstance() {
        if (instance != null)
            return instance;
        else
            return instance = new ConfigManager();
    }

    private void loadConfigFile() {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getRozetkaUrl() {
        return prop.getProperty("url");
    }

    public String getTestDataFilePath() {
        return prop.getProperty("filePath");
    }

    public String getScreenshotsFilePath() {
        return prop.getProperty("pathNameScreenshots");
    }

    public String getDriverName() {
        return prop.getProperty("driverName");
    }

    public String getDriverPath() {
        return prop.getProperty("driverPath");
    }

    public Integer getWaitTime() {
        return Integer.valueOf(prop.getProperty("waitTime"));
    }

}
