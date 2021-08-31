package ladder.domain;

import java.util.*;

public class Line {

    private final Width width;

    private final List<Boolean> points;

    private Line(Width width, List<Boolean> points) {
        this.width = width;
        this.points = points;
    }

    private Line(Width width) {
        this(width, new ArrayList<>());
    }

    public static Line create(List<Boolean> points) {
        return new Line(Width.create(points.size()), points);
    }

    public static Line create(Boolean... points) {
        return new Line(Width.create(points.length), Arrays.asList(points));
    }

    public static Line createWithWidth(Width width) {
        return new Line(width);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public boolean isConnected(int index) {
        if (outOfRange(index)) {
            throw new IndexOutOfBoundsException("사다리의 너비의 범위를 벗어났습니다.");
        }
        return points.get(index);
    }

    public boolean outOfRange(int index) {
        return width.outOfRange(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(width, line.width) && Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, points);
    }

}
