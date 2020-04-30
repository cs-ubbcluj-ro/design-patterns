package ubb.dp1920.examples.behavioural.visitor.shapes;

import ubb.dp1920.examples.behavioural.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
