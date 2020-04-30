package ubb.dp1920.examples.architecture.mvp;

import javax.swing.SwingUtilities;

/**
 * Source: https://riptutorial.com/swing/example/14137/simple-mvp-example
 */
public class Application {
    public Application() {
        final View view = new View();
        final Model model = new Model();
        new Presenter(view, model);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Application();
            }
        });
    }
}