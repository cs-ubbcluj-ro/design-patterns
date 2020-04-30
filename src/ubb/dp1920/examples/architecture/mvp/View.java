package ubb.dp1920.examples.architecture.mvp;

/**
 * Provides the UI elements
 * Source: https://riptutorial.com/swing/example/14137/simple-mvp-example
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.BiConsumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class View {
    // A list of listeners subscribed to this view
    private final ArrayList<ViewListener> listeners;
    private final JLabel label;

    public View() {
        final JFrame frame = new JFrame();
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());

        final JButton button = new JButton("Hello, world!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                notifyListenersOnButtonClicked();
            }
        });
        frame.add(button);
        label = new JLabel();
        frame.add(label);
        this.listeners = new ArrayList<ViewListener>();
        frame.setVisible(true);
    }

    // Iterate through the list, notifying each listner individualy
    private void notifyListenersOnButtonClicked() {
        for (final ViewListener listener : listeners) {
            listener.onButtonClicked();
        }
    }

    // Subscribe a listener
    public void addListener(final ViewListener listener) {
        listeners.add(listener);
    }

    public void setLabelText(final String text) {
        label.setText(text);
    }

    /**
     * Iterates through the subscribed listeneres notifying each listener
     * individually. Note: the {@literal '<T>' in private <T> void} is a Bounded
     * Type Parametre.
     *
     * @param <T>      Any Reference Type (basically a class).
     * 
     * @param consumer A method with two parameters and no return, the 1st parametre
     *                 is a ViewListner, the 2nd parametre is value of type T.
     * 
     * @param data     The value used as parametre for the second argument of the
     *                 method described by the parametre consumer.
     */
    private <T> void notifyListeners(final BiConsumer<ViewListener, T> consumer, final T data) {
        // Iterate through the list, notifying each listener, java8 style
        listeners.forEach((listener) -> {

            // Calls the funcion described by the object consumer.
            consumer.accept(listener, data);

            // When this method is called using ViewListener::onButtonClicked
            // the line: consumer.accept(listener,data); can be read as:
            // void accept(ViewListener listener, ActionEvent data) {
            // listener.onButtonClicked(data);
            // }
        });
    }
}