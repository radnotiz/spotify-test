package my.programming_assignment.spotify_test.ui_tests.login;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_tests.LoginScreen;
import my.programming_assignment.spotify_test.ui_tests.MainScreen;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.sikuli.script.App;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = UiTestModule.class)
public class LoginTest {
	@Inject
	private Logger logger;
	@Inject
	private App app;
	@Inject
	private LoginScreen loginScreen;
	@Inject
	private MainScreen mainScreen;

	@BeforeClass
	public void logOff() throws Exception {
		app.focus();
		if (mainScreen.isLoggedIn()) {
			mainScreen.logOff(); 
		}
	}

	@BeforeMethod
	public void openApp() throws Exception {
		Thread.sleep(1000);
		if (app.open() == null) {
			throw new RuntimeException("Unable to open application. Check logs.");
		}
		app.focus();
	}

	@Test(dataProvider = "invalid-credentials", dataProviderClass = CredentialsProvider.class)
	public void loginWithInvalidCredentials(String username, String password) throws Exception {
		loginScreen.submitCredentials(username, password);
		assertThat(loginScreen.loginFailed(), is(true));
	}

	@Test(groups = "successful-login",
			dataProvider = "valid-credentials",
			dataProviderClass = CredentialsProvider.class)
	public void loginWithValidCredentials(String username, String password) throws Exception {
		loginScreen.submitCredentials(username, password);
		assertThat(mainScreen.isLoggedIn(), is(true));
	}
}
