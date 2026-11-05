package message;

import java.util.ArrayList;

public abstract class Message {

    public abstract String getSender();

    public abstract String getContent();

    public abstract void sendDate();

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean find(ArrayList<String> l){
        for (String s : l){
            if (s.equalsIgnoreCase(getContent())){
                return true;
            }
        }

        return false;
    }

    public String generatePreview(){
        return "";
    }
}
