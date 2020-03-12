package ubb.dp1920.examples.creational;

/**
 * 
 * Singleton example implemented with lazy loading and the double-checked
 * locking design pattern
 *
 */
class MazeFactorySingleton {
	private static volatile MazeFactorySingleton instance = null;

	public static MazeFactorySingleton instance() {
		// Lazy instantiation using the double-checked locking pattern
		if (instance == null) {
			synchronized (MazeFactorySingleton.class) {
				if (instance == null) {
					instance = new MazeFactorySingleton();
				}
			}
		}
		return instance;
	}

	private MazeFactorySingleton() {
	}
}

/**
 * 
 * Singleton example implemented using initialization-on demand holder design
 * pattern
 * 
 * NB! Only works is singleton instance initialization is guaranteed to not fail
 *
 */
class MazeFactorySingletonAgain {
	// 1. The JVM initializes the class trivially, as there are no static fields
	// or blocks

	private MazeFactorySingletonAgain() {
	}

	private static class LazyHolder {
		// 2. Class is only initialized when the JVM must use it (lazy loading)
		static final MazeFactorySingletonAgain INSTANCE = new MazeFactorySingletonAgain();
	}

	public static MazeFactorySingletonAgain getInstance() {
		// 3. JVM initializes LazyHolder here - JSL guarantees class
		// initialization as non-concurrent
		return LazyHolder.INSTANCE;
	}
}

public class MazeSingleton {

}
