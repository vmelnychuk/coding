package io.learn.javacore.effectivejava.creation;

public class StaticFactoryMethod {
}

class MyBoolean {
    public static final MyBoolean TRUE = new MyBoolean(true);
    public static final MyBoolean FALSE = new MyBoolean(false);

    private final boolean value;

    private MyBoolean(boolean value) {
        this.value = value;
    }

    public static MyBoolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }

    public static MyBoolean valueOf(String s) {
        return MyBoolean.parseBoolean(s) ? TRUE : FALSE;
    }

    private static boolean parseBoolean(String s) {
        return "true".equalsIgnoreCase(s);
    }
}
