package ubb.dp1920.examples.creational;

/**
 * 
 * The prototype-based factory inherits from the abstract factory implementation
 *
 */
class MazeFactoryPrototype extends MazeFactory {
	private Maze protoMaze;
	private Wall protoWall;
	private Room protoRoom;
	private Door protoDoor;

	public MazeFactoryPrototype(Maze maze, Wall wall, Room room, Door door) {
		this.protoMaze = maze;
		this.protoWall = wall;
		this.protoRoom = room;
		this.protoDoor = door;
	}

	@Override
	public Maze makeMaze() {
		return protoMaze.clone();
	}

	@Override
	public Room makeRoom(int number) {
		Room room = protoRoom.clone();
		// Configure the newly cloned object
		room.init(number);

		return room;
	}

	@Override
	public Wall makeWall() {
		return (Wall) protoWall.clone();
	}

	@Override
	public Door makeDoor(Room r1, Room r2) {
		Door door = protoDoor.clone();
		// Configure the newly cloned object
		door.init(r1, r2);

		return door;
	}
}

public class PrototypeMaze {
	public static void main(String[] args) {
		MazeGame mg;

		// default maze type using prototypes
		MazeFactoryPrototype mfp = new MazeFactoryPrototype(new Maze(), new Wall(), new Room(), new Door());

		// bombed maze using prototypes
		MazeFactoryPrototype bfp = new MazeFactoryPrototype(new Maze(), new BombedWall(), new RoomWithBomb(),
				new Door());
	}
}
