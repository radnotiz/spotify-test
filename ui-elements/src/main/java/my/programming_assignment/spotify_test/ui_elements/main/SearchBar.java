package my.programming_assignment.spotify_test.ui_elements.main;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class SearchBar implements UiElement {
	private static String imgPath = SearchBar.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
