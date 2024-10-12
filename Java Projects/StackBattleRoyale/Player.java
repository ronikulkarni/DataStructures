public class Player {
    private String name;
    private int numDisks;

    // Constructor
    public Player(String name, int numDisks) {
        this.name = name;
        this.numDisks = numDisks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumDisks() {
        return numDisks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void incrementNumDisks() {
        this.numDisks ++;
    }

    
    // Override toString() for easy display of a Player's information
    @Override
    public String toString() {
        return "Player Name: " + name + ", Number of Disks: " + numDisks;
    }
}
