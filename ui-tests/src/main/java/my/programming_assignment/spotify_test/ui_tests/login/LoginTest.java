package my.programming_assignment.spotify_test.ui_tests.login;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.login.LoginFailedMsg;
import my.programming_assignment.spotify_test.ui_elements.login.UsernameInput;
import my.programming_assignment.spotify_test.ui_elements.main.MusicControl;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = UiTestModule.class)
public class LoginTest {
	@Inject
	private Logger logger;
	@Inject
	private Screen screen;
	@Inject
	private App app;

	@BeforeSuite
	public void checkEnvironment() throws Exception {
		logger.info("Image path: " + Settings.BundlePath);
		logger.info("Screen: " + screen);
		logger.info("App: " + app);
	}

	@BeforeClass
	@AfterMethod
	public void setUp() throws Exception {
		app.focus();
		app.close();
	}

	@BeforeMethod
	public void openApp() throws Exception {
		if (app.open() == null) {
			throw new RuntimeException("Unable to open application. Check logs.");
		}
		app.focus();
	}

	@Test(expectedExceptions = FindFailed.class, expectedExceptionsMessageRegExp = "can not find .*MusicControl.*")
	public void loginWithInvalidPassword() throws Exception {
		screen.click(UsernameInput.imgPath());
		screen.paste("zoltan.radnoti@disney.com");
		screen.type(Key.TAB);
		screen.paste("wrong pass");
		screen.type(Key.ENTER);
		screen.wait(LoginFailedMsg.imgPath(), 10);
		screen.find(MusicControl.imgPath());
	}
}
