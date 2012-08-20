package my.programming_assignment.spotify_test.ui_tests;

import java.io.File;
import java.util.logging.Logger;

import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class UiTestModule extends AbstractModule {
	
	private static final String SIKULI_IMAGE_PATH = "SIKULI_IMAGE_PATH";
	private static final String APP_NAME = "APP_NAME";
	private Logger logger = Logger.getLogger(this.getClass().getName());

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
		return new App(getAppName());
	}

	@Provides
	@Singleton
	public Screen screenProvider() {
		return new Screen();
	}

	private String getAppName() {
		String appName = "Spotify";
		String appNameFromSystemEnv = System.getProperty(APP_NAME);
		if (appNameFromSystemEnv == null) {
			logger.info(APP_NAME + " system property has not been set. Using default.");
		} else {
			appName=appNameFromSystemEnv;
		}
		logger.info("Name of the application to test: " + appName);
		return appName;
	}

	private void setImagePath() {
		if (System.getProperty(SIKULI_IMAGE_PATH) == null) {
			logger.info(SIKULI_IMAGE_PATH + " system property has not been set, trying to find images...");
			Settings.BundlePath = getRelativPathToTheImages();
			logger.info("Image path for Sikuli has been set to: " + Settings.BundlePath);
		}
	}

	private String getRelativPathToTheImages() {
		File codeSourceLocation = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation()
				.getPath());
		String currentDirPath = codeSourceLocation.isDirectory() ? codeSourceLocation.getPath() : codeSourceLocation
				.getParent();
		return new File(currentDirPath).getParent().concat("/images");
	}
}
