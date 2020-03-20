package ubb.dp1920.examples.structural;

import ubb.dp1920.examples.structural.composite.CPU;
import ubb.dp1920.examples.structural.composite.MemoryModule;
import ubb.dp1920.examples.structural.composite.SSD;
import ubb.dp1920.examples.structural.composite.VideoCard;

/**
 * This example continues the Computer one that we used for Composite &
 * Decorator patterns
 * 
 * Computer is a facade to all the subsystem components
 */
class Computer {
    private CPU cpu;
    private MemoryModule memory;
    private VideoCard video;
    private SSD storage;

    private int BOOT_ADDRESS = 0xA100;
    private int BOOT_SECTOR = 0x1000;

    public Computer() {
        cpu = new CPU("Authentic AMD", 320, 95);
        // memory should be abstracted as memory bank, not a module per se
        memory = new MemoryModule("4Gb", 120, 4);
        video = new VideoCard("Fancy video card", 590, 180);
        storage = new SSD("256Gb", 240, 5);
    }

    // In case we just want to start the system
    void start()
    {
        cpu.initialize();
        memory.load(BOOT_ADDRESS, storage.read(BOOT_SECTOR));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

public class FacadeComputerExample {
    public static void main(String[] args) {
        Computer pc = new Computer();
        pc.start();
    }
}