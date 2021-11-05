import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;

public class Grid {
    private LinkedList<Ship> ships;

    public Grid() {
        ships = new LinkedList<>();
    }

    public String repr() {
        StringBuilder buffer = new StringBuilder(" | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n");
        for(int y = 0; y <= 9; y++){
            buffer.append(y);
            buffer.append("|");
            for (int x = 0; x <= 9; x++) {
                final Position p = new Position(x, y);
                ships
                    .stream()
                    .flatMap(s -> s.placeLetter(p).stream())
                    .findAny()
                    .ifPresentOrElse
                        (letter -> buffer.append(" "+letter+" |"),
                        () -> buffer.append("   |"));
            }
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public Grid addGunShip(int x, int y) {
        ships.add(new Ship(Set.of(new Position(x, y)), 'g'));
        return this;
    }

    public Grid addDestroyer(int x, int y, Orientation orientation) {
        switch (orientation) {
            case Horizontal -> ships.add(new Ship(Set.of(new Position(x, y), new Position(x+1, y),new Position(x+2, y)), 'd'));
            case Vertical -> ships.add(new Ship(Set.of(new Position(x, y), new Position(x, y+1),new Position(x, y+2)), 'd'));
        }
        return this;
    }

    private static record Ship(Set<Position> positions, char letter) {
        Optional<Character> placeLetter(Position p) {
            if(positions.contains(p))
                return Optional.of(letter);

            return Optional.empty();
        }
    }
    private static record Position(int x, int y) {

    }

}
