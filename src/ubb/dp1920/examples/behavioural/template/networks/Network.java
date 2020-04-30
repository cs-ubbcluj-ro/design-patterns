package ubb.dp1920.examples.behavioural.template.networks;

/**
 * Abstract class to represent a social network
 */
public abstract class Network {
    String userName;
    String password;

    Network() {
    }

    /**
     * Publish the data to the given network... here be template methods!
     */
    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    /**
     * These are template methods overriden in subclasses
     */
    abstract boolean logIn(String userName, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}