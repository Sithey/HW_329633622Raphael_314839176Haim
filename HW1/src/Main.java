import message.IDigital;
import message.Message;
import message.board.BoardMessage;
import message.board.PriorityType;
import message.email.EmailMessage;
import message.email.File;
import message.sms.PhoneNumberException;
import message.sms.SMSMessage;

import java.util.*;

public class Main {

    public static void main(String[] args){
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new BoardMessage("Raphael", "Hello World !", "Ruppin Team"));
        messages.add(new BoardMessage("Haim", "Hello sir !", null));

        messages.add(new EmailMessage("Ido", "This is a test.", "Test my inbox"));
        messages.add(new EmailMessage("Raphael", "This is the score of your mail", new Date(), "Test my inbox", new ArrayList<>(List.of(new File("report", "csv")))));
        messages.add(new SMSMessage("Kfir", "How are you Yarin ?", "0511234567"));
        messages.add(new SMSMessage("Yarin", "good !", "0511234565"));
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to our app, please select the mode: (1-6)");
            System.out.println("1) Add a message");
            System.out.println("2) remove a message");
            System.out.println("3) Display all the messages");
            System.out.println("4) Count messages by words");
            System.out.println("5) Display digital message");
            System.out.println("6) Clear messages");
            System.out.println("else exit...");
            int choice;
            try {
               choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("bye bye");
                return;
            }
            try {
                if (choice == 1) {
                    System.out.println("what type ? 1. board 2. email 3. sms (1-3)");
                    try {
                        choice = scanner.nextInt();
                    } catch (InputMismatchException e){
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    System.out.println("sender");
                    String sender = scanner.nextLine();
                    System.out.println("content");
                    String content = scanner.nextLine();
                    Message message;
                    if (choice == 1) {
                        System.out.println("are you a part of a team ? blank message for not");
                        String team = scanner.nextLine();
                        message = new BoardMessage(sender, content, team);
                    } else if (choice == 2) {
                        System.out.println("what subject?");
                        String subject = scanner.nextLine();
                        message = new EmailMessage(sender, content, subject);
                    } else if (choice == 3) {
                        System.out.println("what phone?");
                        String phone = scanner.nextLine();
                        message = new SMSMessage(sender, content, phone);
                    } else {
                        System.out.println("wrong type");
                        continue;
                    }
                    messages.add(message);
                } else if (choice == 2) {
                    int count = 1;
                    System.out.println("What message ?");
                    Map<Integer, Message> cache = new HashMap<>();
                    for (Message m : messages) {
                        System.out.println(count + ") " + m.generatePreview());
                        cache.put(count, m);
                        count++;
                    }

                    try {
                        choice = scanner.nextInt();
                    } catch (InputMismatchException e){
                        scanner.nextLine();
                        continue;
                    }
                    if (!cache.containsKey(choice)) {
                        System.out.println("message not found...");
                        continue;
                    }
                    messages.remove(cache.get(choice));
                } else if (choice == 3) {
                    for (Message m : messages) {
                        System.out.println(m.toString());
                    }
                } else if (choice == 4) {
                    System.out.println("write your words");
                    scanner.nextLine();
                    String line = scanner.nextLine();
                    if (line.isBlank()) {
                        System.out.println("no words entered");
                        continue;
                    }
                    ArrayList<String> words = new ArrayList<>(Arrays.asList(line.trim().split("\\s+")));
                    int count = 0;
                    for (Message m : messages) {
                        if (m.find(words)) {
                            count++;
                        }
                    }
                    System.out.println(count + " messages contain at least one of these words");
                } else if (choice == 5) {
                    for (Message m : messages) {
                        if (m instanceof IDigital) {
                            System.out.println(m.generatePreview());
                        }
                    }
                } else if (choice == 6) {
                    messages.clear();
                    System.out.println("messages have been cleared.");
                } else {
                    return;
                }
            }catch (IllegalArgumentException | PhoneNumberException e){
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

}
