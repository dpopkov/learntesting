package learn.junitia.ch08mocks.configurations;

public class DefaultConfiguration implements Configuration {

    public DefaultConfiguration(String configurationName) {
    }

    public String getSQL(String sqlString) {
        return null;
    }
}
