package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverProvider {
    public static DriverConfig driver = ConfigFactory.create(DriverConfig.class, System.getProperties());
    public static void setConfig() {


        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");


        Configuration.baseUrl = DriverProvider.driver.getBaseUrl();
        Configuration.browser = DriverProvider.driver.getBrowserName();
        Configuration.browserSize = DriverProvider.driver.getBrowserSize();

        Configuration.pageLoadStrategy = "eager";


    }
}
