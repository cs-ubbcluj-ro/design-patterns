package ubb.dp1920.examples.behavioural.state.states;

import ubb.dp1920.examples.behavioural.state.ui.Player;

public abstract class State {
    Player player;

    /**
     * EN: Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();

    public abstract String onPlay();

    public abstract String onNext();

    public abstract String onPrevious();
}
