package message.email;

import message.IDigital;
import message.Message;

import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends Message implements IDigital {

    private final ArrayList<File> attachments;
    private final String subject;

    public EmailMessage(String sender, String content, Date sendDate, String subject, ArrayList<File> attachments) {
        super(sender, content, sendDate);
        if (subject == null || subject.isBlank()){
            throw new IllegalArgumentException("Subject is null or empty");
        }
        this.subject = subject;
        this.attachments = attachments == null ? new ArrayList<>() : new ArrayList<>(attachments);
    }

    public EmailMessage(String sender, String content, String subject){
        this(sender, content, new Date(System.currentTimeMillis()), subject, new ArrayList<>());
    }

    public String getSubject() {
        return subject;
    }

    public void addAttachment(File file){
        if (file == null){
            return;
        }
        attachments.add(file);
        updateModification();
    }

    public void removeAttachment(File file){
        boolean removed = attachments.removeIf(attachment -> attachment.equals(file));
        if (!removed){
            throw new AttachmentException(file.getFileName(), file.getFileType());
        }
        updateModification();
    }

    @Override
    public String printCommunicationMethod() {
        return "Sent via Email Server";
    }

    @Override
    public String generatePreview() {
        return "[Email] Subject: " + subject + " | From: " + sender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (File file : attachments){
            sb.append(":").append(file.getFileName()).append(".").append(file.getFileType());
        }

        return super.toString() + ":" + subject + sb;
    }
}
