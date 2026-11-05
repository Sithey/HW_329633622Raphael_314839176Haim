package message.sms;

public class PhoneNumberException extends RuntimeException {
    public PhoneNumberException(String phone) {
        super("This phone " + phone + " number contain not digit character.");
    }
}
