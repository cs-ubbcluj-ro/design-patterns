package ubb.dp1920.examples.behavioural.memento.commands;

import java.awt.Color;

import ubb.dp1920.examples.behavioural.memento.editor.Editor;
import ubb.dp1920.examples.behavioural.memento.shapes.Shape;

public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
