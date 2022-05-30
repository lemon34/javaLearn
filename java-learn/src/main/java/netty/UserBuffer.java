package netty;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.Buffer;
import java.nio.IntBuffer;

@Slf4j
public class UserBuffer  {

    static IntBuffer intBuffer = null;
    public static void allocateTest() {
        intBuffer = IntBuffer.allocate(20);
        log.info("---after allocate---");
        log.info("position:{}", intBuffer.position());
        log.info("limit:{}", intBuffer.limit());
        log.info("capacity:{}", intBuffer.capacity());
    }
    
    public static void putTest() {
        for (int i = 0; i < 5; ++i) {
            intBuffer.put(i);
        }
        log.info("---after put---");
        log.info("position:{}", intBuffer.position());
        log.info("limit:{}", intBuffer.limit());
        log.info("capacity:{}", intBuffer.capacity());
    }

    public static void flipTest() {
        intBuffer.flip();
        log.info("---after flip---");
        log.info("position:{}", intBuffer.position());
        log.info("limit:{}", intBuffer.limit());
        log.info("capacity:{}", intBuffer.capacity());
    }

    public static void main(String[] args) {
        log.info("11212");
        UserBuffer userBuffer = new UserBuffer();
        UserBuffer.allocateTest();
        UserBuffer.putTest();
        UserBuffer.flipTest();
        Gson gson = new Gson();
        log.info("111{}", gson.toJson(UserBuffer.intBuffer));
    }

}
