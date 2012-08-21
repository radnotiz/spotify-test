package my.programming_assignment.spotify_test.ui_elements;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.login.LogIn;
import my.programming_assignment.spotify_test.ui_elements.main.controls.PlayMusic;

import org.sikuli.script.App;
import org.sikuli.script.Screen;

import com.google.inject.Inject;

public class Application {
	@Inject
	private Logger logger;
	@Inject
	private App app;
	@Inject
	private Screen screen;
	@Inject 
	private PlayMusic playMusic;
	@Inject
	private LogIn logIn;

	public void close() {
		app.focus();
		app.close();
	}

	public void open() {
		if (app.open() == null) {
			throw new RuntimeException("Unable to open application. Check Sikuli logs.");
		}
		app.focus();
	}

	public boolean isLoggedIn() throws Exception {
		return screen.exists(playMusic.imgPath()) != null;
	}
	
	public Boolean isLoggedOut() {
		return screen.exists(logIn.imgPath()) != null;
	}
}
