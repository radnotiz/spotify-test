package my.programming_assignment.spotify_test.ui_elements.login;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class LogIn implements UiElement {
	private static String imgPath = LogIn.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
