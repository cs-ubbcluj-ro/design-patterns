package ubb.dp1920.examples.architecture.mvp;

/**
 * Responsible to responding to user interaction and updating the view
 * Source: https://riptutorial.com/swing/example/14137/simple-mvp-example
 */
public class Presenter implements ViewListener {
    private final View view;
    private final Model model;

    public Presenter(final View view, final Model model) {
        this.view = view;
        view.addListener(this);
        this.model = model;
    }

    @Override
    public void onButtonClicked() {
        // Update the model (ie. the state of the application)
        model.addOneToCount();
        // Update the view
        view.setLabelText(String.valueOf(model.getCount()));
    }

    @Override
    public void methodThatTakesALong(long p) {

    }
}