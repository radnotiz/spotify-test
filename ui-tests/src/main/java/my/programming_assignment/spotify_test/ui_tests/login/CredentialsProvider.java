package my.programming_assignment.spotify_test.ui_tests.login;

import org.testng.annotations.DataProvider;

public class CredentialsProvider {
	private static String validUsername = "zoltan.radnoti@disney.com";
	private static String validPassword = "1qasdf";
	private static String invalidUsername = "zoltan.radnoti@disney.comm";
	private static String invalidPassword = "wrongPass";

	@DataProvider(name = "valid-credentials")
	public static Object[][] validCredentials() {
		return new Object[][] { { validUsername, validPassword } };
	}

	@DataProvider(name = "invalid-credentials")
	public static Object[][] invalidCredentials() {
		return new Object[][] { { validUsername, invalidPassword }, { invalidUsername, validPassword },
				{ invalidUsername, invalidPassword } };
	}
}