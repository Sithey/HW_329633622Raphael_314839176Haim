package message.email;

import message.Message;

public class EmailMessage extends Message implements IDigital {


    private String subject;

    public EmailMessage(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void addAttachment(File file){

    }

    public void removeAttachment(File file){

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

    @Override
    public void printCommunicationMethod() {

    }
}
