package ubb.dp1920.examples.behavioural.observer;

import java.io.File;

import ubb.dp1920.examples.behavioural.observer.publisher.EventManager;


/**
 * This class implements the Observable (this is the publisher in the
 * publish-subscribe paradigm)
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
