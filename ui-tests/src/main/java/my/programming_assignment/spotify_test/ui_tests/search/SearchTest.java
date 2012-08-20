package my.programming_assignment.spotify_test.ui_tests.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.main.BobMarley;
import my.programming_assignment.spotify_test.ui_elements.main.EttaJamesSong;
import my.programming_assignment.spotify_test.ui_tests.MainScreen;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = UiTestModule.class)
public class SearchTest {
	@Inject
	private Logger logger;
	@Inject
	private MainScreen mainScreen;
	@Inject
	private BobMarley bobMarley;
	@Inject
	private EttaJamesSong ettaJamesSong;

	@Test(dependsOnGroups = "successful-login")
	public void searchForArtist() throws Exception {
		mainScreen.searchFor("Bob Marley");
		assertThat(mainScreen.isPresent(bobMarley), is(true));
	}

	@Test(groups = "successful-search", dependsOnGroups = "successful-login")
	public void advancedSearch() throws Exception {
		mainScreen.searchFor("artist:'etta james' title:'something' + 'live' album:'At Last'");
		assertThat(mainScreen.isPresent(ettaJamesSong), is(true));
	}

	@Test(dependsOnGroups = "successful-search")
	public void playTrack() throws Exception {
		mainScreen.searchFor("artist:'etta james' title:'something' + 'live' album:'At Last'");
		mainScreen.playMusic(ettaJamesSong);
		Thread.sleep(45000);
	}
}
