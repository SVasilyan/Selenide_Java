package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:test_data/testData.properties"})
public interface DriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();


    @Key("browserSize")
    String getBrowserSize();

    @Key("browserName")
    String getBrowserName();

    @Key("userPassword")
    String getUserPassword();

    @Key("userName")
    String getUserName();

    @Key("adminPassword")
    String getAdminPassword();

    @Key("adminName")
    String getAdminName();

}