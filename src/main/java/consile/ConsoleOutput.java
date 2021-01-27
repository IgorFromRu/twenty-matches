package consile;

public class ConsoleOutput {


    public void outMatches(int matches) {
        System.out.println("На столе осталось " + matches + " спичек.");
    }

    public void outMove(String name, int number) {
        System.out.println("- Количество выбранных " + name + "ом спичек = " + number + ".");
    }

    public void outError() {
        System.out.println("Некорректное количество спичек.");
    }

    public void outMovePlayer() {
        System.out.print("- Ход игрока. Введите количество спичек : ");
    }

    public void outGameOver(String name) {
        System.out.printf("Для " + name + "а осталась последняя спичка. " + name.toUpperCase().charAt(0) + name.substring(1) + " проиграл.");
    }
}
