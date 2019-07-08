package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Bar> bars;

    Line(List<Bar> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        LineMaker lineMaker = new LineMaker();
        return new Line(lineMaker.generateBars(numberOfPlayers));
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }

    Position travel(Position position) {
        if (bars.get(position.getPosition()).isExist()) { //사용자의 현재 위치와 bar의 위치가 같으면 사용자의 현재위치가 1만큼 증가
            return position.moveToRight();
        }
        if (position.getPosition() > 0 && bars.get(position.getLeftPosition()).isExist()) { //사용자의 현재 위치보다 bar의 위치가 1만큼 작으면 사용자의 현재위치는 1만큼 감소
            return position.moveToLeft();
        }
        return position;
    } //TODO: 이 로직을 Bar 객체로 위임하고 싶은데, Bar 2개를 사용해서 위치를 갱신하는 방식이라 이 곳에서 처리하는 상태

}