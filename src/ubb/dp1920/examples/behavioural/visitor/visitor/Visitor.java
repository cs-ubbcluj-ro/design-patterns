package ubb.dp1920.examples.behavioural.visitor.visitor;

import ubb.dp1920.examples.behavioural.visitor.shapes.Circle;
import ubb.dp1920.examples.behavioural.visitor.shapes.CompoundShape;
import ubb.dp1920.examples.behavioural.visitor.shapes.Dot;
import ubb.dp1920.examples.behavioural.visitor.shapes.Rectangle;

/**
 * This interface implements the Visitor pattern
 */
public interface Visitor {
//    String visit(Shape s);

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
