package ubb.dp1920.examples.creational;

/**
 * 
 * This is the default builder.
 *
 */
class MazeBuilder {
	protected MazeBuilder() {
	}

	public void buildMaze() {
	}

	public void buildRoom(int roomNr) {
	}

	public void buildDoor(int roomFrom, int roomTo) {
	}

	public Maze getMaze() {
		return null;
	}
}

/**
 * 
 * A concrete builder
 *
 */
class StandardMazeBuilder extends MazeBuilder {
	private Maze currentMaze;

	@Override
	public void buildMaze() {
		currentMaze = new Maze();
	}

	@Override
	public void buildRoom(int roomNr) {
		Room room = new Room(roomNr);
		currentMaze.addRoom(room);

		room.setSide(Direction.NORTH, new Wall());
		room.setSide(Direction.SOUTH, new Wall());
		room.setSide(Direction.EAST, new Wall());
		room.setSide(Direction.WEST, new Wall());
	}

	@Override
	public void buildDoor(int roomFrom, int roomTo) {
		Room r1 = currentMaze.roomNr(roomFrom);
		Room r2 = currentMaze.roomNr(roomTo);

		Door d = new Door(r1, r2);
		r1.setSide(commonWall(r1, r2), d);
		r2.setSide(commonWall(r2, r1), d);
	}

	@Override
	public Maze getMaze() {
		return currentMaze;
	}

	private Direction commonWall(Room r1, Room r2) {
		// calculate orientation of common wall
		return null;
	}
}

/**
 * 
 * Another concrete builder, calculates the size of a maze
 *
 */
class CountingMazeBuilder extends MazeBuilder {
	private int rooms;
	private int doors;

	@Override
	public void buildDoor(int roomFrom, int roomTo) {
		doors++;
	}

	@Override
	public void buildRoom(int roomNr) {
		rooms++;
	}

	public int getRooms() {
		return rooms;
	}

	public int getDoors() {
		return doors;
	}
}

/**
 * 
 * Creating a maze using the builder
 *
 */
public class BuilderMazeGame {
	public Maze createMaze(MazeBuilder mb) {
		mb.buildMaze();

		mb.buildRoom(1);
		mb.buildRoom(2);
		mb.buildDoor(1, 2);

		return mb.getMaze();
	}

	public static void main(String[] args) {
		MazeBuilder mb = new StandardMazeBuilder();
		Maze m = new BuilderMazeGame().createMaze(mb);

		// Build a counting maze builder
		mb = new CountingMazeBuilder();
		m = new BuilderMazeGame().createMaze(mb);
	}
}
