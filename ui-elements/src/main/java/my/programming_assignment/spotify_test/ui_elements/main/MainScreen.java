package my.programming_assignment.spotify_test.ui_elements.main;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.UiElement;
import my.programming_assignment.spotify_test.ui_elements.main.controls.PlayMusic;
import my.programming_assignment.spotify_test.ui_elements.main.controls.Progress;
import my.programming_assignment.spotify_test.ui_elements.main.header.LogOut;
import my.programming_assignment.spotify_test.ui_elements.main.header.Notifications;
import my.programming_assignment.spotify_test.ui_elements.main.search.ClearSearch;
import my.programming_assignment.spotify_test.ui_elements.main.search.Search;

import org.sikuli.script.AppearEvent;
import org.sikuli.script.Button;
import org.sikuli.script.ChangeEvent;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliEventObserver;
import org.sikuli.script.VanishEvent;

import com.google.inject.Inject;

public class MainScreen {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Inject
	private Screen screen;
	@Inject
	private PlayMusic playMusic;
	@Inject
	private Search search;
	@Inject
	private ClearSearch clearSearch;
	@Inject
	private Notifications notifications;
	@Inject
	private LogOut logOut;
	@Inject
	private Progress progress;

	@Inject
	public MainScreen(Screen screen) {
		this.screen = screen;
		logger.info("SearchBar has been initialized with " + screen);
	}

	public Screen getScreen() {
		return screen;
	}

	public void searchFor(String string) throws Exception {
		Location location = screen.find(search.imgPath()).getCenter().right(30);
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

	public void logOut() throws Exception {
		screen.click(screen.find(notifications.imgPath()).getCenter().right(75));
		screen.getRobot().delay(500);
		screen.click(logOut.imgPath());
		screen.getRobot().delay(2000);
	}

	public boolean isLoggedIn() throws Exception {
		return screen.exists(playMusic.imgPath()) != null;
	}

	public void playTrack(UiElement track) throws Exception {
		screen.doubleClick(track.imgPath());
	}

	public Boolean isSongPlayed() throws Exception {
		final Match match = screen.find(progress.imgPath());
		class TargetChangeObserver implements SikuliEventObserver {
			private boolean targetHasChanged;

			public boolean targetHasChanged() {
				return targetHasChanged;
			}

			@Override
			public void targetVanished(VanishEvent e) {
			}
			@Override
			public void targetChanged(ChangeEvent e) {
				match.stopObserver();
				targetHasChanged = true;
			}
			@Override
			public void targetAppeared(AppearEvent e) {
			}
		}		
		TargetChangeObserver observer = new TargetChangeObserver();
		match.onChange(observer);
		match.observe(5);

		return !observer.targetHasChanged();
	}
}
