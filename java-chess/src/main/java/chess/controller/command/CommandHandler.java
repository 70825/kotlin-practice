package chess.controller.command;

import chess.controller.command.command.Command;
import chess.controller.command.factory.CommandFactory;
import chess.controller.command.factory.EndCommandFactory;
import chess.controller.command.factory.MoveCommandFactory;
import chess.controller.command.factory.StartCommandFactory;
import chess.controller.command.factory.StatusCommandFactory;

import java.util.Arrays;
import java.util.List;

public enum CommandHandler {

    START(1, new StartCommandFactory()),
    MOVE(3, new MoveCommandFactory()),
    STATUS(1, new StatusCommandFactory()),
    END(1, new EndCommandFactory());

    private static final int COMMAND_INDEX = 0;
    private static final String NOT_EXIST_COMMAND_ERROR_MESSAGE = "입력값은 `start`, `move source target`, `status`, `end`만 가능합니다.";

    private final int size;
    private final CommandFactory commandFactory;

    CommandHandler(final int size, final CommandFactory commandFactory) {
        this.size = size;
        this.commandFactory = commandFactory;
    }

    public static Command bind(final List<String> input) {
        return Arrays.stream(CommandHandler.values())
                .filter(commandHandler -> isSameCommand(input, commandHandler))
                .filter(commandHandler -> isSameSize(input, commandHandler))
                .map(commandHandler -> commandHandler.commandFactory.createCommand(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_COMMAND_ERROR_MESSAGE));
    }

    private static boolean isSameCommand(final List<String> input, final CommandHandler commandHandler) {
        return commandHandler.name().toLowerCase().equals(input.get(COMMAND_INDEX));
    }

    private static boolean isSameSize(final List<String> input, final CommandHandler commandHandler) {
        return commandHandler.size == input.size();
    }
}
