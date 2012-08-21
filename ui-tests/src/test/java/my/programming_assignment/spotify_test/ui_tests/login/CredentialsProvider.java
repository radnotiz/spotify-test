package my.programming_assignment.spotify_test.ui_tests.login;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.DataProvider;

public class CredentialsProvider {

	private static String invalidPassword, invalidUsername, validPassword, validUsername;

	private static Properties properties = new Properties();
	static {
		try {
			properties.load(new FileReader(new File(UiTestModule.getCodeSourceLocationPath()).getParent().concat(
					"/credentials.properties")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		invalidUsername = properties.getProperty("invalidUsername","<not set in credentials.properties>");
		invalidPassword = properties.getProperty("invalidPassword","<not set in credentials.properties>");
		validPassword = properties.getProperty("validPassword","<not set in credentials.properties>");
		validUsername = properties.getProperty("validUsername","<not set in credentials.properties>");
	}

	@DataProvider(name = "invalid_credentials")
	public static Object[][] invalidCredentials() {
		return new Object[][] { { validUsername, invalidPassword }, { invalidUsername, validPassword },
				{ invalidUsername, invalidPassword } };
	}

	@DataProvider(name = "valid_credentials")
	public static Object[][] validCredentials() {
		return new Object[][] { { validUsername, validPassword } };
	}

	public static String invalidPassword() {
		return invalidPassword;
	}

	public static String invalidUsername() {
		return invalidUsername;
	}

	public static String validPassword() {
		return validPassword;
	}

	public static String validUsername() {
		return validUsername;
	}
}