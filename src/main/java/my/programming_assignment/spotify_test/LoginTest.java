package my.programming_assignment.spotify_test;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
	private Screen screen;
	private App app;

	@BeforeSuite
	public void initSikuli() throws Exception {
		Settings.BundlePath = this.getClass().getResource("/").getPath();
		screen = new Screen(); // Must precede the call of new App, otherwise it hangs
		app = new App("Spotify");
	}

	@BeforeClass
	@AfterMethod
	public void setUp() throws Exception {
		app.focus();
		app.close();
	}	
	
	@BeforeMethod
	public void openApp() throws Exception {
		if (app.open() == null) {
			throw new RuntimeException("Unable to open application. Check logs.");
		}
		app.focus();
	}

	@Test(expectedExceptions = FindFailed.class, expectedExceptionsMessageRegExp = "can not find imgs/music-control\\.png.*")
	public void loginWithInvalidPassword() throws Exception {
		screen.click("imgs/username-input.png");
		screen.paste("zoltan.radnoti@disney.com");
		screen.type(Key.TAB);
		screen.paste("wrong pass");
		screen.type(Key.ENTER);
		screen.wait("imgs/login-failed.png", 10);
		screen.find("imgs/music-control.png");
	}
}
