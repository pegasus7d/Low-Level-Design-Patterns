package Questions.ElevatorSystem;

public enum Direction {
    UP("Up"),
    DOWN("Down"),
    IDLE("Idle");
    private final String displayName;

    Direction(String displayName){
        this.displayName=displayName;
    }


    public String getDisplayName(){
        return displayName;
    }
}
