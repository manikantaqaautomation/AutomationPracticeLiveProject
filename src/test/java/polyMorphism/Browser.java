package polyMorphism;

//Run-Time Polymorphism (Method Overriding)
//A subclass overrides a method from the superclass with a different implementation.

public class Browser {
	
	public void launchBrowser() {
        System.out.println("Launching generic browser");
    }


/*public class ChromeBrowser extends Browser {
@Override
public void launchBrowser() {
    System.out.println("Launching Chrome browser");
}
}

public class FirefoxBrowser extends Browser {
@Override
public void launchBrowser() {
    System.out.println("Launching Firefox browser");
}
}*/


//Usage

Browser browser;

//browser = new ChromeBrowser();
//browser.launchBrowser();  // Output: Launching Chrome browser

//browser = new FirefoxBrowser();
//browser.launchBrowser();  // Output: Launching Firefox browser
}
