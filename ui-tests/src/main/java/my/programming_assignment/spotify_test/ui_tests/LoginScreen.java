package my.programming_assignment.spotify_test.ui_tests;

import java.util.logging.Logger;

import my.programming_assignment.spotify_test.ui_elements.login.LoginFailedMsg;
import my.programming_assignment.spotify_test.ui_elements.login.UsernameInput;
import my.programming_assignment.spotify_test.ui_elements.main.MusicControl;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.google.inject.Inject;

public class LoginScreen {
	private static final double LOGIN_TIMEOUT_IN_SEC = 10;

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Inject
	private Screen screen;
	@Inject
	private UsernameInput usernameInput;
	@Inject
	private LoginFailedMsg loginFailedMsg;
	@Inject
	private MusicControl musicControl;

	@Inject
	public LoginScreen(Screen screen) {
		this.screen = screen;
		logger.info("LoginScreen has been initialized with " + screen);
	}

	public void submitCredentials(String username, String password) throws Exception {
		screen.click(usernameInput.imgPath());
		screen.paste(username);
		screen.type(Key.TAB);
		screen.getRobot().delay(500);
		screen.paste(password);
		screen.type(Key.ENTER);
	}

	public boolean loginFailed() throws Exception {
		return screen.exists(loginFailedMsg.imgPath(), LOGIN_TIMEOUT_IN_SEC) != null;
	}

	public Boolean isLoggedOut() {
		return screen.exists(usernameInput.imgPath(), LOGIN_TIMEOUT_IN_SEC) != null;
	}
}
