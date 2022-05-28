package netty;

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

    public static void main(String[] args) {
        log.info("11212");
        UserBuffer userBuffer = new UserBuffer();
        UserBuffer.allocateTest();
    }

}
