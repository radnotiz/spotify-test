package my.programming_assignment.spotify_test.ui_tests.search;

import static my.programming_assignment.spotify_test.ui_tests.login.CredentialsProvider.validPassword;
import static my.programming_assignment.spotify_test.ui_tests.login.CredentialsProvider.validUsername;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import my.programming_assignment.spotify_test.ui_elements.login.LoginScreen;
import my.programming_assignment.spotify_test.ui_elements.main.MainScreen;
import my.programming_assignment.spotify_test.ui_elements.main.search.BobMarley;
import my.programming_assignment.spotify_test.ui_elements.main.search.EttaJamesSong;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Test(groups = "functional_test")
@Guice(modules = UiTestModule.class)
public class SearchTest {
	@Inject
	private MainScreen mainScreen;
	@Inject
	private LoginScreen loginScreen;
	@Inject
	private BobMarley bobMarley;
	@Inject
	private EttaJamesSong ettaJamesSong;

	@BeforeClass
	public void logIn() throws Exception {
		if (loginScreen.isLoggedOut()) {
			loginScreen.submitCredentials(validUsername(), validPassword());
		}
	}

	@Test(groups = "successful_search", dependsOnGroups = "successful_login")
	public void searchForArtist() throws Exception {
		mainScreen.searchFor("Bob Marley");
		assertThat(mainScreen.isPresent(bobMarley), is(true));
	}

	@Test(groups = "successful_search", dependsOnGroups = "successful_login")
	public void advancedSearch() throws Exception {
		mainScreen.searchFor("artist:'Etta James' title:'Something' + 'live' album:'At Last'");
		assertThat(mainScreen.isPresent(ettaJamesSong), is(true));
	}
}
