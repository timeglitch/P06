public class Intersection {

    private final int x;
    private final int y;
    
    Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof Intersection && this.x == ((Intersection)o).getX() && this.y == ((Intersection)o).getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
    } 

    public Intersection goNorth() {
        return new Intersection(x, y + 1);
    }

    public Intersection goSouth() {
        return new Intersection(x, y - 1);
    }

    public Intersection goEast() {
        return new Intersection(x + 1, y);
    }

    public Intersection goWest() {
        return new Intersection(x - 1, y);
    }

}
