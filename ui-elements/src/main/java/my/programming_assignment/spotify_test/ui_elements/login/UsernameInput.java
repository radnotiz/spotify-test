package my.programming_assignment.spotify_test.ui_elements.login;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class UsernameInput implements UiElement {
	private static String imgPath = UsernameInput.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
