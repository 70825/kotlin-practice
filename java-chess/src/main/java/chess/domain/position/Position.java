package chess.domain.position;

import chess.domain.piece.Direction;

import java.util.Objects;

public final class Position {

    private static final int FILE_INDEX = 0;
    private static final int RANK_INDEX = 1;

    private final File file;
    private final Rank rank;

    private Position(final File file, final Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public static Position from(final String input) {
        validateInputLength(input);
        File file = File.of(input.charAt(FILE_INDEX));
        Rank rank = Rank.of(input.charAt(RANK_INDEX));

        return new Position(file, rank);
    }

    private static void validateInputLength(final String input) {
        if (isNotTwoLength(input)) {
            throw new IllegalArgumentException("위치는 2글자입니다 (ex. a1, d3, h8)");
        }
    }

    private static boolean isNotTwoLength(final String input) {
        return input.length() != 2;
    }

    public static Position of(final File file, final Rank rank) {
        return new Position(file, rank);
    }

    public Position add(final Direction unitVector) {
        final File nextFile = File.of((char) (file() + unitVector.getDx()));
        final Rank nextRank = Rank.of(rank() + unitVector.getDy());

        return new Position(nextFile, nextRank);
    }

    public int diffFile(final Position target) {
        return target.file() - this.file();
    }

    public int diffRank(final Position target) {
        return target.rank() - this.rank();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    public char file() {
        return file.value();
    }

    public int rank() {
        return rank.value();
    }
}
