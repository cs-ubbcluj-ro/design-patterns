package ubb.dp1920.examples.behavioural.memento;

/**
 * Example source:
 * https://refactoring.guru/design-patterns/memento
 */
import java.awt.Color;

import ubb.dp1920.examples.behavioural.memento.editor.Editor;
import ubb.dp1920.examples.behavioural.memento.shapes.Circle;
import ubb.dp1920.examples.behavioural.memento.shapes.CompoundShape;
import ubb.dp1920.examples.behavioural.memento.shapes.Dot;
import ubb.dp1920.examples.behavioural.memento.shapes.Rectangle;


public class MementoExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
