package ubb.dp1920.examples.behavioural.visitor;

import ubb.dp1920.examples.behavioural.visitor.shapes.Circle;
import ubb.dp1920.examples.behavioural.visitor.shapes.CompoundShape;
import ubb.dp1920.examples.behavioural.visitor.shapes.Dot;
import ubb.dp1920.examples.behavioural.visitor.shapes.Rectangle;
import ubb.dp1920.examples.behavioural.visitor.shapes.Shape;
import ubb.dp1920.examples.behavioural.visitor.visitor.XMLExportVisitor;

public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
