package parsing;

public class Main {
    int i;
    double d;
    float f;
    Integer ii;
    Double dd;
    Float ff;

    public static void main(String[] args) {
        Main m = new Main();
        m.dd=1.0/0;
        m.ff=1.1f/0.3f;
//        m.ii=1/0;
        System.out.println(m.d);
        System.out.println(m.i);
        System.out.println(m.f);

        System.out.println(m.dd);
        System.out.println(m.ii);
        System.out.println(m.ff);
        System.out.println(m.dd.isInfinite());
        System.out.println(m.ff.isInfinite());
        System.out.println(m.ii);




    }
}
