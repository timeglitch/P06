import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PathUtilsTester {

    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
        int startX, startY, endX, endY;
        String input = "Y";
        while (input.equalsIgnoreCase("Y")) {
        System.out.print("Enter starting X coordinate: ");
        startX = keyboard.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        startY = keyboard.nextInt();
        System.out.print("Enter ending X coordinate: ");
        endX = keyboard.nextInt();
        System.out.print("Enter ending Y coordinate: ");
        endY = keyboard.nextInt();
        Intersection start = new Intersection(startX, startY);
        Intersection end = new Intersection(endX, endY);
        System.out.println("Number of paths from start to end: " + PathUtils.countPaths(start, end));
        System.out.println("List of possible paths:");
        for (Path p : PathUtils.findAllPaths(start, end)) {
        System.out.println(p);
        }
        do {
        System.out.print("Try another route? (Y/N): ");
        input = keyboard.next();
        } while (!input.equalsIgnoreCase("Y")
        && !input.equalsIgnoreCase("N"));
        }
        }
    }

    public static boolean testCountPathsNoPath() {
        return PathUtils.countPaths(new Intersection(3, 3), new Intersection(1, 2)) == 0;
    }

    public static boolean testCountPathsOnePath() {
        return PathUtils.countPaths(new Intersection(1, 1), new Intersection(1, 2)) == 0;
    }

    public static boolean testCountPathsRecursive() {
        return PathUtils.countPaths(new Intersection(1, 1), new Intersection(3, 3)) == 0;
    }

    public static boolean testFindAllPathsNoPath() {
        ArrayList<Path> temp = PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(0, 0));
        return temp.size() == 0;
    }

    public static boolean testFindAllPathsOnePath() {
        ArrayList<Path> temp = PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(1, 2));
        return temp.size() == 1;
    }

    public static boolean testFindAllPathsRecursive() {
        
        ArrayList<Path> temp = PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(3, 3));
        return temp.size() == 6;
    }

}
