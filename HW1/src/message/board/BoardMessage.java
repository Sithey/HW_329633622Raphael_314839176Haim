package message.board;

import message.Message;

import java.util.Date;

public class BoardMessage extends Message {

    private PriorityType priority;
    private String team = null;

    public BoardMessage(String sender, String content, Date sendDate, PriorityType priority, String team){
        super(sender, content, sendDate);
        if (priority == null)
            priority = PriorityType.REGULAR;

        this.priority = priority;
        this.team = team;
    }

    public BoardMessage(String sender, String content, String team){
        this(sender, content, new Date(System.currentTimeMillis()),PriorityType.REGULAR, team);
    }

    public PriorityType getPriority() {
        return priority;
    }

    public boolean hasTeam(){
        return team != null && !team.isBlank();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
        updateModification();
    }

    public void setPriority(PriorityType priorityType) {
        if (priorityType == null)
            priorityType = PriorityType.REGULAR;
        this.priority = priorityType;
        updateModification();
    }

    @Override
    public String generatePreview() {
        return "[Board] " + sender + ": " + content.substring(0, Math.min(15, content.length())) + (content.length() > 15 ? "..." : "");
    }

    @Override
    public String toString() {
        return super.toString() + ":" + priority.name() + ":" + (team == null || team.isBlank() ? "no team" : team);
    }
}
