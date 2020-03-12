package ubb.dp1920.examples.creational;

import java.util.ArrayList;
import java.util.List;

enum Direction {
	NORTH, SOUTH, EAST, WEST
}

/**
 * 
 * The abstract @MapSite class defines a maze element
 *
 * The clone() operation is required for the Prototype pattern
 */
abstract class MapSite {
	public void enter() {
	}
}

/**
 * 
 * A concrete room of the @Maze
 *
 */
class Room extends MapSite {
	private int roomNumber;
	private MapSite[] sides;

	public Room(int roomNr) {
		init(roomNr);
	}

	// required only for Prototype pattern
	public Room() {
	}

	// required only for Prototype pattern
	public void init(int roomNr) {
		this.roomNumber = roomNr;
		this.sides = new MapSite[4];
	}

	public MapSite getSide(Direction dir) {
		switch (dir) {
		case NORTH:
			return sides[0];
		case SOUTH:
			return sides[1];
		case EAST:
			return sides[2];
		case WEST:
			return sides[3];
		}
		return null;
	}

	public void setSide(Direction dir, MapSite site) {
		switch (dir) {
		case NORTH:
			sides[0] = site;
		case SOUTH:
			sides[1] = site;
		case EAST:
			sides[2] = site;
		case WEST:
			sides[3] = site;
		}
	}

	// Required only for Prototype pattern
	public Room clone() {
		return new Room(roomNumber);
	}
}

/**
 * 
 * Represent a wall between two rooms
 *
 */
class Wall extends MapSite {
	public Wall() {
	}

	public void Enter() {
	}

	// Required only for Prototype pattern
	public Wall clone() {
		return new Wall();
	}
}

/**
 * 
 * A door connects two Rooms, can be open or closed
 *
 */
class Door extends MapSite {
	private Room room1, room2;

	public Door(Room room1, Room room2) {
		init(room1, room2);
	}

	// required only for Prototype pattern
	public Door() {
	}

	public void init(Room room1, Room room2) {
	}

	public void Enter() {
	}

	public Room otherSideFrom(Room room) {
		return null;
	}

	// Required only for Prototype pattern
	public Door clone() {
		return new Door(room1, room2);
	}
}

/**
 * 
 * A Maze is basically a collection of connected rooms
 *
 */
class Maze {
	private List<MapSite> elements;

	public Maze() {
		elements = new ArrayList<MapSite>();
	}

	public void addRoom(Room room) {
		elements.add(room);
	}

	public Room roomNr(int roomNr) {
		// linear search, hash table etc...
		return null;
	}

	public List<MapSite> getElements() {
		return elements;
	}

	// Required only for Prototype pattern
	public Maze clone() {
		return new Maze();
	}
}

/**
 * 
 * We will use this class to assemble a maze throughout our examples
 *
 */
public class DefaultMaze {
	public Maze createMaze() {
		Maze amazeing = new Maze();
		Room r1 = new Room(1);
		Room r2 = new Room(2);
		Door theDoor = new Door(r1, r2);

		amazeing.addRoom(r1);
		amazeing.addRoom(r2);
		r1.setSide(Direction.NORTH, new Wall());
		r1.setSide(Direction.EAST, theDoor);
		r1.setSide(Direction.SOUTH, new Wall());
		r1.setSide(Direction.WEST, new Wall());

		r2.setSide(Direction.NORTH, new Wall());
		r2.setSide(Direction.WEST, theDoor);
		r2.setSide(Direction.SOUTH, new Wall());
		r2.setSide(Direction.EAST, new Wall());
		return amazeing;
	}
}
