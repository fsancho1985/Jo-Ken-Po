import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static JoKenPo startGame() {
        System.out.println("========== Jo-Ken-Po =========\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        String playerName = scan.next().toUpperCase();

        Player user = new Player(playerName);
        Player CPU = new Player("CPU");

        System.out.print(playerName + " insira o número de rounds: ");
        int rounds = scan.nextInt();

        return new JoKenPo(user, CPU, rounds);
    }

    public static void main(String[] args) {
        JoKenPo jokenpo = startGame();
        jokenpo.toPlay();
        jokenpo.showWinner();
    }
}
