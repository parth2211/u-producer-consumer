import producerconsumer.Consumer;
import producerconsumer.MessageRepository;
import producerconsumer.Producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageRepository messageRepository = new MessageRepository(false);
        List<String> listString = new ArrayList<>(Arrays.asList("Statement...1", "Statement...2", "Statement...3", "Statement...4"
        , "Statement...4", "Statement...5", "FINISHED"));
        Thread producer = new Thread(new Producer(messageRepository, listString));
        Thread consumer = new Thread(new Consumer(messageRepository));

        consumer.start();
        producer.start();
    }
}