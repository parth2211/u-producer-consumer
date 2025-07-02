package producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    MessageRepository msgRepository;

    public Consumer(MessageRepository msgRepository) {
        this.msgRepository = msgRepository;
    }

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5, 50));
                String s = msgRepository.read();
                if (s.equals("FINISHED")) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
