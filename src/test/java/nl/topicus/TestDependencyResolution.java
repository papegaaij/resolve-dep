package nl.topicus;

import java.io.File;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;

public class TestDependencyResolution {
	@Test
	public void resolveDeps() {
		File[] jars = Maven.configureResolver().workOffline()
				.loadPomFromFile("pom.xml")
				.importCompileAndRuntimeDependencies().resolve()
				.withTransitivity().as(File.class);

		Assert.assertEquals("Exactly 2 files were resolved", 2, jars.length);
	}
}
