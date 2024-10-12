import java.util.Random;

public class Game {
    private static final int STACK_COUNT = 3;
    private static final String[] STACK_NAMES = {"Stack A", "Stack B", "Stack C"};
    private LinkedStack<Disk>[] stacks;
    private Player player1;
    private Player player2;
  

    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name,0);
        this.player2 = new Player(player2Name,0);
        stacks = new LinkedStack[STACK_COUNT];
        
        for (int i = 0; i < STACK_COUNT; i++) {
            stacks[i] = new LinkedStack<>();
        }
    }

    public void start(int rounds) {
        Random random = new Random();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);

            // Player 1's turn
            playerTurn(player1, random);
            // Player 2's turn
            playerTurn(player2, random);

            // Automatic popping mechanism
            if (round % 6 == 0) popDisk(stacks[0], "A");
            if (round % 9 == 0) popDisk(stacks[1], "B");
            if (round % 12 == 0) popDisk(stacks[2], "C");

            //displayStacks();
        }

        declareWinner();
    }

private void playerTurn(Player player, Random random) {
    int stackIndex = random.nextInt(STACK_COUNT);
    Disk disk = new Disk(player); // Use the Player instance

    System.out.println(player.getName() + " pushes a disk onto " + STACK_NAMES[stackIndex]);

    // Check if the top disk belongs to the opponent
    if (!stacks[stackIndex].isEmpty() && stacks[stackIndex].peek().getPlayer() != player) {
        stacks[stackIndex].pop(); // Pop the opponent's disk
        System.out.println(getOpponent(player).getName() + "'s disk popped!");
    }

    stacks[stackIndex].push(disk);
    player.incrementNumDisks();
}

 private void popDisk(LinkedStack<Disk> stack, String stackName) {
        if (!stack.isEmpty()) {
            stack.pop();
            System.out.println("Automatic pop from " + stackName);
        }
    }

    private Player getOpponent(Player player) {
        return player == player1 ? player2 : player1;
    }

  /* private void displayStacks() {
    for (int i = 0; i < STACK_COUNT; i++) {
        System.out.print(STACK_NAMES[i] + ": ");
        for (int j = 0; j < stacks[i].size(); j++) {
            System.out.print(stacks[i].peek().getPlayer().getName() + " "); // Get the player's name
        }
        System.out.println();
    }
}*/

    private void declareWinner() {
        if (player1.getNumDisks() > player2.getNumDisks()) {
            System.out.println(player1.getName() + " wins with " + player1.getNumDisks() + " disks!");
        } else if (player2.getNumDisks() > player1.getNumDisks()) {
            System.out.println(player2.getName() + " wins with " + player2.getNumDisks() + " disks!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}