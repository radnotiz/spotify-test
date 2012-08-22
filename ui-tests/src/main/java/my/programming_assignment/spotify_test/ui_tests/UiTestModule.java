package my.programming_assignment.spotify_test.ui_tests;

import java.io.File;
import java.util.logging.Logger;

import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class UiTestModule extends AbstractModule {

	private static final String DEFAULT_TESTDATA_DIR = "testdata";
	private static final String PROP_SIKULI_IMAGE_PATH = "SIKULI_IMAGE_PATH";
	private static final String PROP_APP_NAME = "APP_NAME";

	private static Logger logger = Logger.getLogger(UiTestModule.class.getName());

	public static String getCodeSourceLocationPath() {
		File codeSourceLocation = new File(UiTestModule.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath());
		return codeSourceLocation.isDirectory() ? codeSourceLocation.getPath() : codeSourceLocation.getParent();
	}

	public static String getTestDataDirPath() {
		String testdataDir = System.getProperty("TESTDATA_DIR", DEFAULT_TESTDATA_DIR);
		String path;
		if (testdataDir.startsWith("/")) {
			path = testdataDir;
		} else {
			path = new File(UiTestModule.getCodeSourceLocationPath()).getParent().concat("/" + testdataDir);
		}
		return path;
	}

	@Override
	protected void configure() {
		setImagePath();
	}

	/**
	 * 
	 * @param screen
	 *            added to be sure that Screen initialization precede the initialization of App, otherwise Screen
	 *            initialization hangs up
	 * @return
	 */
	@Provides
	@Singleton
	public App appProvider(Screen screen) {
		App app = new App(getAppName());
		logger.info("App initialized: " + app);
		return app;
	}

	@Provides
	@Singleton
	public Screen screenProvider() {
		Screen screen = new Screen();
		logger.info("Screen initialized: " + screen);
		return screen;
	}

	private String getAppName() {
		String appName = "Spotify";
		String appNameFromSystemEnv = System.getProperty(PROP_APP_NAME);
		if (appNameFromSystemEnv == null) {
			logger.info(PROP_APP_NAME + " system property has not been set. Using default.");
		} else {
			appName = appNameFromSystemEnv;
		}
		logger.info("Name of the tested application has been set to: " + appName);
		return appName;
	}

	private void setImagePath() {
		if (System.getProperty(PROP_SIKULI_IMAGE_PATH) == null) {
			logger.info(PROP_SIKULI_IMAGE_PATH + " system property has not been set, trying to find images...");
			Settings.BundlePath = getRelativPathToTheImages();
			logger.info("Image path for Sikuli has been set to: " + Settings.BundlePath);
		}
	}

	private String getRelativPathToTheImages() {
		return new File(getCodeSourceLocationPath()).getParent().concat("/images");
	}
}
