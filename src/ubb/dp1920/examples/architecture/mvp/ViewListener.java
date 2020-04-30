package ubb.dp1920.examples.architecture.mvp;

/**
 * Provides methods to notify on user interaction Source:
 * https://riptutorial.com/swing/example/14137/simple-mvp-example
 */
public interface ViewListener {
    public void onButtonClicked();

    // Example of methodThatTakesALong signature
    public void methodThatTakesALong(long p);
}