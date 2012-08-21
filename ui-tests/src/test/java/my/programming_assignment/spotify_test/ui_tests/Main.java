package my.programming_assignment.spotify_test.ui_tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		XmlSuite suite = new XmlSuite();
		suite.setName("All");

		XmlTest test = new XmlTest(suite);
		test.setName("SpotifyTest");
		List<XmlPackage> packages = new ArrayList<XmlPackage>();
		packages.add(new XmlPackage(this.getClass().getPackage().getName() + ".*"));
		test.setPackages(packages);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}
}
