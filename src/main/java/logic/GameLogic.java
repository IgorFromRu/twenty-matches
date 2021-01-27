package logic;

import consile.ConsoleOutput;

import java.util.Scanner;

public class GameLogic {
    ComputerLogic computer;
    ConsoleOutput console;
    int matches;
    Scanner in;

    public void start() {
        matches = 20;
        computer = new ComputerLogic();
        console = new ConsoleOutput();

        for (int count = 1; count < 20; count++) {
            console.outMatches(matches);
            if (count % 2 != 0) {
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

    private void checkGameOver(String name, int matches) {
        if (matches == 1) {
            console.outGameOver(name);
            in.close();
            System.exit(0);
        }
    }
}
