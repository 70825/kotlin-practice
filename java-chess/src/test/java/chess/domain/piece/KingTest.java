package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.domain.piece.Direction.LEFT_DOWN_DOWN;
import static chess.domain.piece.Direction.LEFT_UP;
import static chess.domain.piece.PieceConstants.EMPTY;
import static chess.domain.team.Team.WHITE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {
    @Test
    @DisplayName("킹이 이동할 수 있으면 true를 반환한다")
    void movable() {
        // given
        final King king = new King(WHITE);

        // then
        assertTrue(king.movable(LEFT_UP, EMPTY));
    }

    @Test
    @DisplayName("킹이 이동할 수 없으면 false를 반환한다")
    void notMovable() {
        // given
        final King king = new King(WHITE);

        // then
        assertFalse(king.movable(LEFT_DOWN_DOWN, EMPTY));
    }

    @Test
    @DisplayName("킹은 한 칸만 이동할 수 있다")
    void movableByCount() {
        // given
        final King king = new King(WHITE);

        // then
        assertTrue(king.movableByCount(1));
    }

    @Test
    @DisplayName("킹은 두 칸 이상 이동할 수 없다")
    void notMovableByCountOver2() {
        // given
        final King king = new King(WHITE);

        // then
        assertFalse(king.movableByCount(2));
    }
}
