import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Path {

    private ArrayList<Intersection> intersections;

    public Path() {
        intersections = new  ArrayList<Intersection>();

    }

    public int length() {
        return intersections.size();
    }

    public Intersection getHead() throws NoSuchElementException{
        if(length() == 0) {
            throw new NoSuchElementException();
        }
        else {
            return intersections.get(0);
        }
    }

    public Intersection getTail() throws NoSuchElementException{
        if(length() == 0) {
            throw new NoSuchElementException();
        }
        else {
            return intersections.get(length() - 1);
        }
    }

    public void addTail(Intersection toAdd) throws IllegalArgumentException {
        try {
            if(toAdd.equals(getTail().goEast()) || toAdd.equals(getTail().goNorth())) {
                intersections.add(toAdd);
                return;
            }

        }
        catch(NoSuchElementException e) {
            intersections.add(toAdd);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void addHead(Intersection toAdd) throws IllegalArgumentException {
        try {
            if(toAdd.equals(getHead().goWest()) || toAdd.equals(getHead().goSouth())) {
                intersections.add(0, toAdd);
                return;
            }

        }
        catch(NoSuchElementException e) {
            intersections.add(0, toAdd);
            return;
        }
        throw new IllegalArgumentException(toAdd.toString() + " > " + toString());
    }

    public String toString() {
        if (length() == 0) {
            return "Empty";
        }
        String out = intersections.get(0).toString();
        for (int i = 1; i < length(); i++) {
            out = out + "->" + intersections.get(i).toString();

        }
        return out;
    }
    
}
