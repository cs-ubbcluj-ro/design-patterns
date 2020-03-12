package ubb.dp1920.examples.creational;

/**
 * 
 * The AbstractFactory implementation
 * 
 * possible variations:
 * 
 * 1. Abstract methods - every one must be implemented by subclasses
 * 
 * 2. Interface instead of abstract base class
 *
 */
abstract class MazeFactory {
	public MazeFactory() {
	}

	public Maze makeMaze() {
		return new Maze();
	}

	public Wall makeWall() {
		return new Wall();
	}

	public Room makeRoom(int number) {
		return new Room(number);
	}

	public Door makeDoor(Room r1, Room r2) {
		return new Door(r1, r2);
	}
}

/**
 * 
 * Enchanted Maze - a concrete factory
 *
 */
class EnchantedMazeFactory extends MazeFactory {
	public EnchantedMazeFactory() {
	}

	@Override
	public Room makeRoom(int number) {
		return new EnchantedRoom(number, new Spell());
	}
}

class EnchantedRoom extends Room {
	private int number;
	private Spell spell;

	public EnchantedRoom(int number, Spell spell) {
		super(number);
		this.number = number;
		this.spell = spell;
	}
}

class Spell {
	public Spell() {
	}
}

/**
 * 
 * Building a Maze using an abstract factory
 *
 */
public class AbstractFactoryMazeGame {
	public Maze createMaze(MazeFactory mf) {
		Maze aMaze = mf.makeMaze();
		Room r1 = mf.makeRoom(1);
		Room r2 = mf.makeRoom(2);
		Door door = mf.makeDoor(r1, r2);
		aMaze.addRoom(r1);
		aMaze.addRoom(r2);

		r1.setSide(Direction.NORTH, mf.makeWall());
		r1.setSide(Direction.SOUTH, mf.makeWall());
		r1.setSide(Direction.EAST, door);
		r1.setSide(Direction.WEST, mf.makeWall());

		r2.setSide(Direction.NORTH, mf.makeWall());
		r2.setSide(Direction.SOUTH, mf.makeWall());
		r2.setSide(Direction.EAST, mf.makeWall());
		r2.setSide(Direction.WEST, door);
		return aMaze;
	}

	public static void main(String[] args) {
		AbstractFactoryMazeGame afm = new AbstractFactoryMazeGame();

		// Create a default maze factory
		afm.createMaze(new MazeFactory() {
		});

		// Maze factory to build an enchanted maze
		afm.createMaze(new EnchantedMazeFactory());
	}
}
