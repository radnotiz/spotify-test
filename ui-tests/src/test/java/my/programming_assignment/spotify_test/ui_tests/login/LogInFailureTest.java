package my.programming_assignment.spotify_test.ui_tests.login;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import my.programming_assignment.spotify_test.ui_elements.Application;
import my.programming_assignment.spotify_test.ui_elements.login.LoginScreen;
import my.programming_assignment.spotify_test.ui_elements.main.MainScreen;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Test(groups = "functional_test")
@Guice(modules = UiTestModule.class)
public class LogInFailureTest {
	@Inject
	private Application application;
	@Inject
	private LoginScreen loginScreen;
	@Inject
	private MainScreen mainScreen;

	@BeforeMethod
	public void openApp() throws Exception {
		application.open();
		if (application.isLoggedIn()) {
			mainScreen.logOut();
			Thread.sleep(500);
		}
	}

	@Test(groups = "login_failure", dataProvider = "invalid_credentials", dataProviderClass = CredentialsProvider.class)
	public void loginWithInvalidCredentials(String username, String password) throws Exception {
		loginScreen.submitCredentials(username, password);
		assertThat(loginScreen.loginFailed(), is(true));
	}

	@AfterMethod
	public void closeApp() throws Exception {
		application.close();
		Thread.sleep(500);
	}
}
