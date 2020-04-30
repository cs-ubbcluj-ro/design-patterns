package ubb.dp1920.examples.architecture.mvp;

/**
 * A minimal class to maintain some state Source:
 * https://riptutorial.com/swing/example/14137/simple-mvp-example
 */
public class Model {
    private int count = 0;

    public void addOneToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}