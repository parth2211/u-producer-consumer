package producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageRepository {
    private String message;
    private boolean hasMessage;

    public MessageRepository(boolean hasMessage) {
        this.hasMessage = hasMessage;
    }

    public synchronized void write(String msg) {
        while(hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = msg;
        System.out.println("Thread - " + Thread.currentThread().getName() + " Written message : " + msg);
        hasMessage = true;
        notifyAll();
    }

    public synchronized String read() {
        while(!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread - " + Thread.currentThread().getName() + " Read message : " + this.message);
        hasMessage = false;
        notifyAll();
        return this.message;
    }
}
