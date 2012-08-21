package my.programming_assignment.spotify_test.ui_tests.login;

import static my.programming_assignment.spotify_test.ui_tests.login.CredentialsProvider.validPassword;
import static my.programming_assignment.spotify_test.ui_tests.login.CredentialsProvider.validUsername;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import my.programming_assignment.spotify_test.ui_elements.Application;
import my.programming_assignment.spotify_test.ui_elements.login.LoginScreen;
import my.programming_assignment.spotify_test.ui_elements.main.MainScreen;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = UiTestModule.class)
public class LogOutTest {
	@Inject
	private Application application;
	@Inject
	private LoginScreen loginScreen;
	@Inject
	private MainScreen mainScreen;

	@BeforeMethod
	public void openApp() throws Exception {
		if (loginScreen.isLoggedOut()) {
			loginScreen.submitCredentials(validUsername(), validPassword());
		}
	}

	@Test(dependsOnGroups = "successful-login")
	public void logOff() throws Exception {
		mainScreen.logOut();
		assertThat(loginScreen.isLoggedOut(), is(true));
	}
}
