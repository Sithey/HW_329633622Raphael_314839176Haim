package message;

import java.util.ArrayList;
import java.util.Date;

public abstract class Message {

    protected String sender;

    protected String content;

    protected Date sendDate;
    protected Date modificationDate;

    public Message(String sender, String content) throws IllegalArgumentException{
        this(sender, content, new Date(System.currentTimeMillis()));
    }

    public Message(String sender, String content, Date sendDate) throws IllegalArgumentException{
        if (sender == null || content == null || sendDate == null || sender.isBlank() || content.isBlank()){
            throw new IllegalArgumentException("sender or content or sendDate is null or empty");
        }
        this.sender = sender;
        this.content = content;
        this.sendDate = sendDate;
        this.modificationDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws IllegalArgumentException {
        if (content == null || content.isBlank()){
            throw new IllegalArgumentException("content is null or empty");
        }
        this.content = content;
        updateModification();
    }

    protected void updateModification(){
        modificationDate = new Date(System.currentTimeMillis());
    }

    public String getSender() {
        return sender;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    public String toString() {
        return sender + ":" + content + ":" + sendDate.toString() + ":" + modificationDate;
    }

    public boolean find(ArrayList<String> l){
        for (String s : l){
            if (content.toLowerCase().contains(s.toLowerCase())){
                return true;
            }
        }

        return false;
    }

    public abstract String generatePreview();
}
