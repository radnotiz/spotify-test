package my.programming_assignment.spotify_test.ui_elements;

import java.util.logging.Logger;

import org.sikuli.script.App;

import com.google.inject.Inject;

public class Application {
	@Inject
	private Logger logger;
	@Inject
	private App app;

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
}
