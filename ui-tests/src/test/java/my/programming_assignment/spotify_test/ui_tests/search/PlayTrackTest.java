package my.programming_assignment.spotify_test.ui_tests.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import my.programming_assignment.spotify_test.ui_elements.main.MainScreen;
import my.programming_assignment.spotify_test.ui_elements.main.search.EttaJamesSong;
import my.programming_assignment.spotify_test.ui_tests.UiTestModule;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Test(groups = "functional_test")
@Guice(modules= UiTestModule.class)
public class PlayTrackTest {
	@Inject
	private MainScreen mainScreen;
	@Inject
	private EttaJamesSong ettaJamesSong;

	@BeforeMethod
	public void searchForEttaJamesSong() throws Exception {
		mainScreen.searchFor("artist:'etta james' title:'something' + 'live' album:'At Last'");
	}
	
	@Test(dependsOnGroups = "successful_search")
	public void playTrack() throws Exception {
		mainScreen.playTrack(ettaJamesSong);
		assertThat("Song is not played",mainScreen.isSongPlayed(), is(true));
	}
}
