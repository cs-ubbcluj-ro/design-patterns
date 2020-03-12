package ubb.dp1920.examples.recap.inheritance;
/*
    Java does not support multiple inheritance. The closest you can come to it is using the Java 8 feature
    of deafult interface methods.
*/

interface IRogueOne {
    public default void method() {
        System.out.println("Default method in IRogueOne");
    }
}

interface IRogueTwo {
    public default void method() {
        System.out.println("Default method in IRogueTwo");
    }
}

public class Inheritance implements IRogueOne,IRogueTwo{

    public void method() {
        IRogueOne.super.method();
        IRogueTwo.super.method();
    }

    public static void main(final String[] args) {
        final Inheritance obj = new Inheritance();
        obj.method();
    }
}