package mal;

public class Shape {
    int sp;
    String Symbol;
    byte count;
    public Shape () {
        sp = 0;
        Symbol = "*  ";
        count = 10;
    }
    public void draw () {
        System.out.print(Symbol);
    }
}
