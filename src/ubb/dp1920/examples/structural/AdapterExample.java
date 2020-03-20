package ubb.dp1920.examples.structural;

import java.awt.Point;

/**
 * 
 * TextView class should be adapted to the Shape contract. We implement the
 * TextShape adapter
 *
 */

class Shape {
	public Shape() {
	}

	/**
	 * 
	 * Bounding box defined using opposite corner points
	 * 
	 * @param bottomLeft
	 * @param topRight
	 */
	public Point[] boundingBox() {
		return new Point[2];
	}

	/**
	 * 
	 * For this method, TextView has no correspondent
	 * 
	 * @return
	 */
	Manipulator createManipulator() {
		return null;
	}
}

class TextView {
	public TextView() {
	}

	/**
	 * TextView origin
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Point getOrigin() {
		return new Point(0, 0);
	}

	/**
	 * TextView width and height
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public Point getExtent() {
		return new Point(0, 0);
	}

	public boolean isEmpty() {
		return true;
	}
}

/**
 * 
 * Adapter class between Shape and TextView
 * 
 */
class TextShape extends Shape {
	private TextView tv;

	public TextShape(TextView tv) {
		this.tv = tv;
	}

	/**
	 * This method adapts from TextView to Shape
	 */
	public Point[] boundingBox() {
		Point origin = tv.getOrigin();
		Point size = tv.getExtent();

		// adapt here
		Point bottomLeft = new Point(origin.x, origin.y + size.x);
		Point topRight = new Point(origin.x + size.x, origin.y);

		return new Point[] { bottomLeft, topRight };
	}

	/**
	 * This is just a forwarding, best case for an adapter
	 */
	public boolean isEmpty() {
		return tv.isEmpty();
	}

	Manipulator createManipulator() {
		return new TextManipulator();
	}
}

interface Manipulator {

}

class TextManipulator implements Manipulator {

}

public class AdapterExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Shape shape = new Shape();
		TextView tv = new TextView();

		// adapt the TextView to Shape
		TextShape textShape = new TextShape(tv);

		// now we can access TextView functionality using the TextShape adapter
		// as TextShape derives Shape, it "is" a shape object
		Shape newShape = textShape;
	}
}
