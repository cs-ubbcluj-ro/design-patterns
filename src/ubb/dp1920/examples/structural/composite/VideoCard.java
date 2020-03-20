package ubb.dp1920.examples.structural.composite;

public class VideoCard extends SimpleEquipment {
    public VideoCard(String name, int power, int price) {
        super(name, power, price);
    }

    @Override
    public void diagnostic() {
        System.out.println("Video Card diagnostic");
    }
}