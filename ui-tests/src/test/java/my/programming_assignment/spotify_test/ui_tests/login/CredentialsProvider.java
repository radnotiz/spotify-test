package my.programming_assignment.spotify_test.ui_tests.login;

import org.testng.annotations.DataProvider;

public class CredentialsProvider {
	private static String invalidPassword = "wrongPass";
	private static String invalidUsername = "zoltan.radnoti@disney.comm";
	private static String validPassword = "1qasdf";
	private static String validUsername = "zoltan.radnoti@disney.com";

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