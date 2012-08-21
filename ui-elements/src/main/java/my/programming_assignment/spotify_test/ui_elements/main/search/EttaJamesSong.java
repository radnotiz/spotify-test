package my.programming_assignment.spotify_test.ui_elements.main.search;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class EttaJamesSong implements UiElement {
	private static String imgPath = EttaJamesSong.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
