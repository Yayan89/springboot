package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

interface Wow {
    void setPoint();
    void test();


    /**
     * Picks the winners from the specified set of players.
     * <p>
     * The returned list defines the order of the winners, where the first
     * prize goes to the player at position 0. The list will not be null but
     * can be empty.
     *
     * @apiNote This method was added after the interface was released in
     *          version 1.0. It is defined as a default method for compatibility
     *          reasons. From version 2.0 on, the method will be abstract and
     *          all implementations of this interface have to provide their own
     *          implementation of the method.
     * @implSpec The default implementation will consider each player a winner
     *           and return them in an unspecified order.
     * @implNote This implementation has linear runtime and does not filter out
     *           null players.
     * @param players
     *            the players from which the winners will be selected
     * @return6221 the (ordered) list of the players who won; the list will not
     *         contain duplicates
     * @since 1.1
     */
    default List<String> pickWinners(Set<String> players) {
        return new ArrayList<>(players);
    }
}

abstract class AbstractWow implements Wow {
    @Override
    public void setPoint() {
        throw new UnsupportedOperationException("ovverride me");
    }

    @Override
    public void test() {
        throw new UnsupportedOperationException("ovverride me");
    }

}
public class Effective {
    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint p4 = new ColorPoint(1, 2, Color.RED);
        ColorPoint p2 = new ColorPoint(1, 2, Color.BLUE);
        Point p3 = new Point(1, 2);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p4));
        System.out.println(p1.equals(p3));


        OuterClass.ableToBeInInner();;
        OuterClass.nestedStaticClass outerClass = new OuterClass.nestedStaticClass();
        System.out.println(outerClass.beers);
        outerClass.test();
        System.out.println(OuterClass.nestedStaticClass.cookies);


        OuterClass outerClass1 = new OuterClass();
        OuterClass.nestedClass nestedClass = outerClass1.new nestedClass();
    }

    static Wow invoke() {
        return new AbstractWow() {
            @Override
            public void setPoint() {
                System.out.println("fine I am overwriting over you!");
            }
        };
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point p))
            return false;
        return p.x == x && p.y == y;
    }
}

class ColorPoint {
    private final Point point;
    private final Color color;


    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint cp))
            return false;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
