package logic;

public class ComputerLogic {

    public int move(int matches) {
        int moveReturn = 0;
        if (matches == 20) {
            moveReturn = 3;
        } else if (matches <= 16 && matches > 13) {
            moveReturn = matches - 13;
        } else if (matches <= 13 && matches > 9) {
            moveReturn = matches - 9;
        } else if (matches <= 9 && matches > 5) {
            moveReturn = matches - 5;
        } else if (matches <= 5 && matches > 1) {
            moveReturn = matches - 1;
        }
        return moveReturn;
    }
}
