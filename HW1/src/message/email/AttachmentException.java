package message.email;

public class AttachmentException extends RuntimeException
{
    public AttachmentException(String name, String format) {
        super("attachment " + name + "." + format + " not found.");
    }
}
