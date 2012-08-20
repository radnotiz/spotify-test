package my.programming_assignment.spotify_test.ui_tests;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.UiElement;
import my.programming_assignment.spotify_test.ui_elements.main.ClearSearch;
import my.programming_assignment.spotify_test.ui_elements.main.LogOut;
import my.programming_assignment.spotify_test.ui_elements.main.MusicControl;
import my.programming_assignment.spotify_test.ui_elements.main.Notifications;
import my.programming_assignment.spotify_test.ui_elements.main.SearchBar;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.google.inject.Inject;

public class MainScreen {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Inject
	private Screen screen;
	@Inject
	private MusicControl musicControl;
	@Inject
	private SearchBar searchBar;
	@Inject
	private ClearSearch clearSearch;
	@Inject
	private Notifications notifications;
	@Inject
	private LogOut logOut;

	@Inject
	public MainScreen(Screen screen) {
		this.screen = screen;
		logger.info("SearchBar has been initialized with " + screen);
	}

	public void searchFor(String string) throws Exception {
		Location location = screen.find(searchBar.imgPath()).getCenter().right(30);
		screen.hover(location);
		for (int i = 0; i < 3; i++) {
			screen.mouseDown(Button.LEFT);
			screen.mouseUp(Button.LEFT);
		}
		screen.paste(string);
		screen.type(Key.ENTER);
	}

	public Boolean isPresent(UiElement uiElement) {
		return screen.exists(uiElement.imgPath()) != null;
	}

	public void logOff() throws Exception {
		screen.click(screen.find(notifications.imgPath()).getCenter().right(75));
		screen.getRobot().delay(500);
		screen.click(logOut.imgPath());
		screen.getRobot().delay(2000);
	}

	public boolean isLoggedIn() throws Exception {
		return screen.exists(musicControl.imgPath()) != null;
	}

	public void playMusic(UiElement track) throws Exception {	
		screen.doubleClick(track.imgPath());
	}

	public Screen getScreen() {
		return screen;
	}
}
