package ubb.dp1920.examples.behavioural.state;

import ubb.dp1920.examples.behavioural.state.ui.Player;
import ubb.dp1920.examples.behavioural.state.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
