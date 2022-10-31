import java.util.ArrayList;

import java.util.ArrayList;

public class PathUtils {
    public PathUtils() {

    }

    public static int countPaths(Intersection start, Intersection end) {
        return notfindAllPaths(start, end).size(); //TODO do this properly

    }

    public static ArrayList<Path> notfindAllPaths(Intersection start, Intersection end) {
        ArrayList<Path> paths = new ArrayList<Path>();
        
        if(start.getX() > end.getX() && start.getY() > end.getY()) {
            return paths;
        }
        
        if(start.equals(end)) {
            Path base = new Path();
            base.addHead(end);
            paths.add(base);
        }
        
        if(start.getX() < end.getX()) {
            ArrayList<Path> xpaths = notfindAllPaths(start.goEast(), end);
            paths.addAll(xpaths);
        }
        if(start.getY() < end.getY()) {
            ArrayList<Path> ypaths = notfindAllPaths(start.goNorth(), end);
            paths.addAll(ypaths);        
        }
        for (Path path : paths) {
            path.addHead(start);
        }

        return paths;
    }

    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
        ArrayList<Path> paths = new ArrayList<Path>();
        
        if(start.getX() > end.getX() || start.getY() > end.getY()) {
            return paths;
        }

        if(start.equals(end)) {
            Path base = new Path();
            paths.add(base);
        }
        
        if(start.getX() < end.getX()) {
            ArrayList<Path> xpaths = findAllPaths(start.goEast(), end);
            paths.addAll(xpaths);
        }
        if(start.getY() < end.getY()) {
            ArrayList<Path> ypaths = findAllPaths(start.goNorth(), end);
            paths.addAll(ypaths);        
        }
        for (Path path : paths) {
            path.addHead(start);
        }

        return paths;
    }
    
}