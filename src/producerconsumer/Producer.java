package producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{

    MessageRepository msgRepository;
    List<String> stringList;

    public Producer(MessageRepository msgRepository, List<String> list) {
        this.stringList = list;
        this.msgRepository = msgRepository;
    }

    @Override
    public void run() {
        for(String producedString : stringList) {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5, 50));
                msgRepository.write(producedString);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            };
        }
    }
}
