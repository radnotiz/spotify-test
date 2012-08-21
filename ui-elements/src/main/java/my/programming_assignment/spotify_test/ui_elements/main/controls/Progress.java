package my.programming_assignment.spotify_test.ui_elements.main.controls;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class Progress implements UiElement {
	private static String imgPath = Progress.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
