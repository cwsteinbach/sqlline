package sqlline;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Booter
{
    public static final String SERVICE_LOCATOR = "serviceLocator";

    public static final String GUICE = "guice";


    public static String selectFactory( String[] args )
    {
        if ( args == null || args.length == 0 )
        {
            return SERVICE_LOCATOR;
        }
        else
        {
            return args[0];
        }
    }

    public static RepositorySystem newRepositorySystem( final String factory )
    {
        switch ( factory )
        {
            case SERVICE_LOCATOR:
                return sqlline.ManualRepositorySystemFactory.newRepositorySystem();
            default:
                throw new IllegalArgumentException( "Unknown factory: " + factory );
        }
    }

    public static DefaultRepositorySystemSession newRepositorySystemSession( RepositorySystem system )
    {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

        LocalRepository localRepo = new LocalRepository( System.getProperty("user.home") + File.separator + ".m2/repository");
        session.setLocalRepositoryManager( system.newLocalRepositoryManager( session, localRepo ) );

        return session;
    }

    public static List<RemoteRepository> newRepositories( RepositorySystem system, RepositorySystemSession session )
    {
        return new ArrayList<>( Collections.singletonList( newCentralRepository() ) );
    }

    private static RemoteRepository newCentralRepository()
    {
        return new RemoteRepository.Builder( "central", "default", "https://repo.maven.apache.org/maven2/" ).build();
    }

}