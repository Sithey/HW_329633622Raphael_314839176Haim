package message.sms;

import message.IDigital;
import message.Message;
import message.board.PriorityType;

import java.util.Date;

public class SMSMessage extends Message implements IDigital {

    private final String phone;
    public SMSMessage(String sender, String content, Date sendDate, String phone) throws IllegalArgumentException, PhoneNumberException{
        super(sender, content, sendDate);
        if (phone == null || phone.isBlank()){
            throw new IllegalArgumentException("phone is blank");
        }

        for (char c : phone.toCharArray()){
            if (!Character.isDigit(c)){
                throw  new PhoneNumberException(phone);
            }
        }
        this.phone = phone;
    }

    public SMSMessage(String sender, String content, String phone){
        this(sender, content, new Date(System.currentTimeMillis()), phone);
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String generatePreview() {
        return "[SMS] " + phone + " ( " + sender + " ) : " +  content.substring(0, Math.min(15, content.length())) + (content.length() > 15 ? "..." : "");
    }

    @Override
    public String toString() {
        return super.toString() + ":" + phone;
    }

    @Override
    public String printCommunicationMethod() {
        return "Sent via SMS System";
    }
}
