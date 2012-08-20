package my.programming_assignment.spotify_test.ui_elements.main;

import my.programming_assignment.spotify_test.ui_elements.UiElement;

public class EttaJamesAlbumCover implements UiElement {
	private static String imgPath = EttaJamesAlbumCover.class.getName().replaceAll("\\.", "/") + ".png";

	public String imgPath() {
		return imgPath;
	}
}
