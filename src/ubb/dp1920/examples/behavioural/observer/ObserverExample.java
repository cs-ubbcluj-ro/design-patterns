package ubb.dp1920.examples.behavioural.observer;

import ubb.dp1920.examples.behavioural.observer.listeners.EmailNotificationListener;
import ubb.dp1920.examples.behavioural.observer.listeners.LogOpenListener;

public class ObserverExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
