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

        }
        this.message = msg;
        System.out.println("Thread - " + Thread.currentThread().getName() + " Written message : " + msg);
        hasMessage = true;
    }

    public synchronized String read() {
        while(!hasMessage) {

        }
        System.out.println("Thread - " + Thread.currentThread().getName() + " Read message : " + this.message);
        hasMessage = false;
        return this.message;
    }
}
