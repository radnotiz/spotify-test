package my.programming_assignment.spotify_test.ui_tests.login;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_tests.LoginScreen;
import my.programming_assignment.spotify_test.ui_tests.MainScreen;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.sikuli.script.App;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = UiTestModule.class)
public class LogOutTest {
	@Inject
	private Logger logger;
	@Inject
	private App app;
	@Inject
	private LoginScreen loginScreen;
	@Inject
	private MainScreen mainScreen;

	@AfterTest
	public void setUp() throws Exception {
		app.focus();
		app.close();
	}

	@BeforeMethod
	public void openApp() throws Exception {
		app.focus();
	}
	
	@Test(dependsOnGroups = "successful-login")
	public void logOff() throws Exception {
		mainScreen.logOff();
		assertThat(loginScreen.isLoggedOut(), is(true));
	}
}
