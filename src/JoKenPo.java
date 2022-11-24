import java.util.Random;
import java.util.Scanner;

public record JoKenPo(
        Player user,
        Player CPU,
        int rounds
) {
    public void toPlay() {
        System.out.println("\n========== Seja Bem-Vindo(a), " + user.getName() +
                " =========\n");
        for (int i = 1; i <= rounds; i++) {
            int userChoice = userChoice();
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("\n JOGADA INVÁLIDA! (1, 2, 3): ");
                System.out.println("\tPONTO PARA " + CPU.getName() + " \n");
                CPU.incrementScore();
            }
            int cpuChoice = cpuChoice();
            System.out.println("\n" + userChoice + " X " + cpuChoice + "\n");
            int result = userChoice - cpuChoice;
            winner(result);
        }

    }

    public void showWinner() {
        System.out.println("\n======================================\n");
        Integer finalUserScore = user.getScore();
        Integer finalCPUScore = CPU.getScore();

        System.out.println("\n\tFINAL SCORE: " + user.getName() + " " +
                finalUserScore + " X " + finalCPUScore + " " + CPU.getName());
        if (finalUserScore == finalCPUScore) {
            System.out.println("\t\t\tDRAW!");
        } else {
            String finalWinner = (finalUserScore > finalCPUScore) ?
                    user.getName() : CPU.getName();
            System.out.println("\t\tWINNER = " + finalWinner.toUpperCase());
        }
        System.out.println("\n======================================\n");
    }

    private void winner(int result) {
        String winnerRound;
        if (result == 0) {
            winnerRound = "It's a Draw!";
        } else {
            if (result == -1 || result == 2) {
                CPU().incrementScore();
                winnerRound = CPU().getName();
            } else {
                user().incrementScore();
                winnerRound = user().getName();
            }
        }
        System.out.println("\nThe Round Winner: " + winnerRound + "\n");
    }


    private int cpuChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private int userChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - PEDRA");
        System.out.println("2 - PAPEL");
        System.out.println("3 - TESOURA");

        System.out.print("Informe sua jogada: ");

        return scan.nextInt();
    }

}
