public class Disk {
    private Player player;
  
    // Constructor
    public Disk(Player player) {
        this.player = player;
    }

    // Getters
    public Player getPlayer() {
        return player;
    }

    // Setters
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    // Override toString() for easy display of a Player's information
    @Override
    public String toString() {
        return "Disk belongs to Player : " + player.getName();
    }
}