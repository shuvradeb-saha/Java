package autoboxingunboxing;

public class BooleanAutoUnboxing {

    public static void main(String[] args) {
        // This will get an NPE
        Boolean b = null;
        boolean bprimitive = b;
        System.out.println(bprimitive);
    }
}
