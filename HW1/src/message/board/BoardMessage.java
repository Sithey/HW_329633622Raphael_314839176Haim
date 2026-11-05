package message.board;

import message.Message;

public class BoardMessage extends Message {

    private PriorityType priorityType;

    public BoardMessage(PriorityType priorityType){
        this.priorityType = priorityType;
    }

    public PriorityType getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(PriorityType priorityType) {
        this.priorityType = priorityType;
    }

    @Override
    public String getSender() {
        return "";
    }

    @Override
    public String getContent() {
        return "";
    }

    @Override
    public void sendDate() {

    }
}
