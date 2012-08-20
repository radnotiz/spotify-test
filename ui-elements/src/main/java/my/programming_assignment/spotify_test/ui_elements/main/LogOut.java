package my.programming_assignment.spotify_test.ui_elements.main;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class LogOut implements UiElement {
	private static String imgPath = LogOut.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
