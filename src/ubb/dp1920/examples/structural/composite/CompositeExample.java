package ubb.dp1920.examples.structural.composite;

public class CompositeExample {
	public static void main(String[] args) {
		// 1. Create a laptop
		Equipment laptop = new Chassis("My laptop", 5, 100);
		laptop.add(new CPU("Intel 7200U", 15, 250));
		laptop.add(new SSD("Samsung 850 EVO", 3, 200));
		laptop.add(new MemoryModule("4Gb", 1, 180));
		laptop.add(new MemoryModule("4Gb", 1, 180));

		System.out.println("Work Laptop price is " + Integer.toString(laptop.getPrice()) + ", power consumption is "
				+ Integer.toString(laptop.getPower()) + "W");

		// 2. Create a gaming desktop
		Equipment desktop = new Chassis("My gaming battlestation", 15, 150);
		desktop.add(new CPU("Intel 9900K", 95, 450));

		Equipment redundantRAID = new RAIDController("RAID5", 10, 50);
		desktop.add(redundantRAID);

		Equipment raid0 = new RAIDController("RAID-0", 5, 25);
		raid0.add(new SSD("Samsung 850 EVO", 3, 200));
		raid0.add(new SSD("Samsung 850 EVO", 3, 200));
		redundantRAID.add(raid0);

		Equipment raid1 = new RAIDController("RAID-1", 5, 25);
		raid1.add(new SSD("Samsung 850 EVO", 3, 200));
		raid1.add(new SSD("Samsung 850 EVO", 3, 200));
		redundantRAID.add(raid1);

		VideoCard vc = new VideoCard("GTX 1080", 180, 445);
		desktop.add(vc);

		MemoryModule mm = new MemoryModule("8Gb", 2, 85);
		desktop.add(mm);
		desktop.add(new MemoryModule("8Gb", 2, 85));

		System.out.println("Battlestation price is " + Integer.toString(desktop.getPrice()) + ", power consumption is "
				+ Integer.toString(desktop.getPower()) + "W");

		// 3. Diagnose gaming desktop components (chain of responsibility pattern)
		// 3.a The video card has its own diagnostic
		vc.diagnostic();
		// 3.b The MemoryModule does not, so the chain is walked until the first
		// component -> the chassis in our case
		mm.diagnostic();
	}
}
