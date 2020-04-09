package ubb.dp1920.examples.behavioural.observer.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
