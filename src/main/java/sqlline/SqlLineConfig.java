package sqlline;

import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.context.environment.Environment;
import org.cfg4j.source.context.environment.ImmutableEnvironment;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.cfg4j.source.files.FilesConfigurationSource;
import org.cfg4j.source.reload.ReloadStrategy;
import org.cfg4j.source.reload.strategy.PeriodicalReloadStrategy;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SqlLineConfig
{
    private String filesPath; // Run with -DconfigFilesPath=<configFilesPath> parameter to override

//    public ConfigurationProvider configurationProvider() {
//        // Specify which files to load. Configuration from both files will be merged.
//        ConfigFilesProvider configFilesProvider = () -> Arrays.asList(new File("sqlline.yaml"), new File("otherConfig.properties"));
//
//        // Use local files as configuration store
//        ConfigurationSource source = new FilesConfigurationSource(configFilesProvider);
//
//        // Use relative paths
//        Environment environment = new ImmutableEnvironment(filesPath);
//
//        // Reload configuration every 5 seconds
//        ReloadStrategy reloadStrategy = new PeriodicalReloadStrategy(5, TimeUnit.SECONDS);
//
//        // Create provider
//        return new ConfigurationProviderBuilder()
//                .withConfigurationSource(source)
//                .withReloadStrategy(reloadStrategy)
//                .withEnvironment(environment)
//                .build();
//    }
}
