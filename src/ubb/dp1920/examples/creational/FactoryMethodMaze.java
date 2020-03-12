package ubb.dp1920.examples.creational;

/**
 * 
 * Use factory methods which have defaults implemented
 * 
 * Check out the createMaze method
 *
 */
class MazeGame {
	public Maze makeMaze() {
		return new Maze();
	}

	public Room makeRoom(int roomNr) {
		return new Room(roomNr);
	}

	public Wall makeWall() {
		return new Wall();
	}

	public Door makeDoor(Room r1, Room r2) {
		return new Door(r1, r2);
	}

	public Maze createMaze() {
		Maze aMaze = makeMaze();

		Room r1 = makeRoom(1);
		Room r2 = makeRoom(2);
		Door door = makeDoor(r1, r2);
		aMaze.addRoom(r1);
		aMaze.addRoom(r2);

		r1.setSide(Direction.NORTH, makeWall());
		r1.setSide(Direction.SOUTH, makeWall());
		r1.setSide(Direction.EAST, door);
		r1.setSide(Direction.WEST, makeWall());

		r2.setSide(Direction.NORTH, makeWall());
		r2.setSide(Direction.SOUTH, makeWall());
		r2.setSide(Direction.EAST, makeWall());
		r2.setSide(Direction.WEST, door);
		return aMaze;
	}
}

/**
 * 
 * This time we go pew pew
 *
 */
class BombedMazeGame extends MazeGame {
	public BombedMazeGame() {
	}

	public Wall makeWall() {
		return new BombedWall();
	}

	public Room makeRoom(int roomNr) {
		return new RoomWithBomb(roomNr);
	}
}

class BombedWall extends Wall {
}

class RoomWithBomb extends Room {
	// required only for Prototype pattern
	public RoomWithBomb() {
	}

	public RoomWithBomb(int roomNr) {
		super(roomNr);
	}

}

public class FactoryMethodMaze {
	public static void main(String[] args) {
		MazeGame mf;

		// 1. Default maze with factory methods
		mf = new MazeGame();
		Maze m = mf.createMaze();

		for (MapSite ms : m.getElements()) {
			System.out.println(ms.toString());
		}

		// 2. Bombed maze with factory methods
		mf = new BombedMazeGame();
		m = mf.createMaze();

		for (MapSite ms : m.getElements()) {
			System.out.println(ms.toString());
		}
	}
}
