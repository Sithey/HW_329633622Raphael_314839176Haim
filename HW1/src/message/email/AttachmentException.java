package message.email;

public class AttachmentException extends RuntimeException
{
    public AttachmentException() {
        super("error with your attachment.");
    }
}
