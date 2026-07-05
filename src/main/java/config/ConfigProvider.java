package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:config.properties")
public interface ConfigProvider extends Config {

    ConfigProvider CONFIG =
            ConfigFactory.create(ConfigProvider.class);

    @Key("baseUrl")
    String baseUrl();

    @Key("token")
    String token();

    @Key("projectId")
    String projectId();
}
