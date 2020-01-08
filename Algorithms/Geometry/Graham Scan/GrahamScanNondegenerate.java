import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/******************************************************************************
 *  Convex hull. Given set of N points in the Euclidean plane, find minimum area convex region that contains every point.
 *
 *  https://algs4.cs.princeton.edu/99hull/
 *
 *  Compilation:  javac GrahamaScanNondegenerate.java
 *  Execution:    java GrahamNondegenerate < input.txt
 *  Dependencies: Point2D.java Stack.java
 *
 *  Read points from standard input and compute their convex hull
 *  using Graham's algorithm.
 *
 *  Returns the extreme points of the convex hull in counterclockwise
 *  order (starting with the point with smallest y-coordinate).
 *
 *  Non-degeneracy assumption
 *  -------------------------
 *   -  at least 3 points
 *   -  no coincident points
 *   -  no 3 collinear points
 *
 *  GrahamScanNondegenerate.java removes these degeneracy assumptions.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 ******************************************************************************/

import java.util.Arrays;

public class GrahamScanNondegenerate {
    private Stack<Point2D> hull = new Stack<Point2D>();

    public GrahamScanNondegenerate(Point2D[] points) {
        // defensive copy
        int n = points.length;
        if (n <= 2) throw new RuntimeException("Requires at least 3 points");
        Point2D[] a = new Point2D[n];
        for (int i = 0; i < n; i++)
            a[i] = points[i];

        // preprocess so that a[0] has lowest y-coordinate; break ties by x-coordinate
        // a[0] is an extreme point of the convex hull
        // (could do easily in linear time)
        Arrays.sort(a, Point2D.Y_ORDER);

        // sort by polar angle with respect to base point a[0].
        // (no ties because of general position assumption)
        Arrays.sort(a, 1, n, a[0].polarOrder());

        // a[0] and a[1] are extreme points (a[1] because of general position)
        hull.push(a[0]);
        hull.push(a[1]);

        // Graham scan
        for (int i = 2; i < n; i++) {
            Point2D top = hull.pop();
            // could replace >= with > since no three collinear
            // could replace unnecessary popping/pushing with peekpeek()
            while (Point2D.ccw(hull.peek(), top, a[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(a[i]);
        }

        assert isConvex();
    }


    // return extreme points on convex hull in counterclockwise order as an Iterable
    // (no need to reverse if we want to return in clockwise order)
    public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull) s.push(p);
        return s;
    }

    // check that boundary of hull is strictly convex
    private boolean isConvex() {
        int n = hull.size();
        Point2D[] points = new Point2D[n];
        int k = 0;
        for (Point2D p : hull()) {
            points[k++] = p;
        }

        // needs to check i = 1 and i = 2 cases if not in general position
        for (int i = 0; i < n; i++) {
            if (Point2D.ccw(points[i], points[(i+1) % n], points[(i+2) % n]) <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Unit tests the {@code GrahamScan} data type.
     * Reads in an integer {@code n} and {@code n} points (specified by
     * their <em>x</em>- and <em>y</em>-coordinates) from standard input;
     * computes their convex hull; and prints out the points on the
     * convex hull to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Graham Scan Test");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of points");

        int n = sc.nextInt();
        Point2D[] points = new Point2D[n];

        System.out.println("Enter the coordinates of each points: <x> <y>");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point2D(x, y);
        }

        System.out.println("The convex hull consists of following points: ");
        GrahamScanNondegenerate graham = new GrahamScanNondegenerate(points);
        for (Point2D p : graham.hull())
            System.out.println(p);
    }
}
