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

public class DriverResolver
{

    public static File resolveDriverArtifact(String artifactId) {
        return null;
    }

    public static DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system) {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

        LocalRepository localRepo = new LocalRepository("target/local-repo");
        session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

        return session;
    }

    public static List<RemoteRepository> newRepositories( RepositorySystem system, RepositorySystemSession session ) {
        return new ArrayList<>( Collections.singletonList( newCentralRepository() ) );
    }

    private static RemoteRepository newCentralRepository() {
        return new RemoteRepository.Builder( "central", "default", "https://repo.maven.apache.org/maven2/" ).build();
    }
}
