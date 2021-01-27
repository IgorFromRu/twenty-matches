package logics;

import console.ConsoleOutput;

import java.util.Scanner;

public class GameLogic {
    private ComputerLogic computer;
    private ConsoleOutput console;
    private int matches;
    private Scanner in;

    /**
     * Запускает игру
     */
    public void start() {
        matches = 20;
        computer = new ComputerLogic();
        console = new ConsoleOutput();

        for (int countMove = 1; countMove < 20; countMove++) {
            console.outMatches(matches);
            if (countMove % 2 != 0) {
                int numberComp = computer.move(matches);
                matches -= numberComp;
                console.outMove("компьютер", numberComp);
                checkGameOver("игрок", matches);
            } else {
                console.outMovePlayer();
                int numberPlayer = checkMove();
                matches -= numberPlayer;
                console.outMove("игроком", numberPlayer);
                checkGameOver("компьютер", matches);
            }

        }
    }

    /**
     * Проверяет введенное число игрока в консоли от 1 до 3
     * @return возвращает число введенное игроком
     */
    private int checkMove() {
        in = new Scanner(System.in);
        int numberPlayer = 0;
        while (in.hasNext()) {
            numberPlayer = in.nextInt();
            if (numberPlayer > 3 || numberPlayer < 1 || numberPlayer > matches - 1) {
                console.outError();
                console.outMovePlayer();
            } else {
                break;
            }
        }
        return numberPlayer;
    }

    /**
     * Проверяет число оставшихся спичек и если спичка остается одна, объявляет проигравшего
     * (игрока т.к в игру не возможно выиграть) и выходит из программы
     * @param name Имя соперника
     * @param matches Количество спичек
     */
    private void checkGameOver(String name, int matches) {
        if (matches == 1) {
            console.outGameOver(name);
            in.close();
            System.exit(0);
        }
    }
}
