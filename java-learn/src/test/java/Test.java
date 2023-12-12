import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuhailong
 * @Description TODO fhl
 * @Date 2023/8/26 16:20
 **/

@Slf4j
public class Test {

    public static void main(String[] args) {
        List<TestJson> testJsonList = new ArrayList<>();
        TestJson testJson1 = new TestJson("A1", "B1");
        TestJson testJson2 = new TestJson("A3", "B3");
        TestJson testJson3 = new TestJson("A2", "B2");
        testJsonList.add(testJson1);
        testJsonList.add(testJson2);
        testJsonList.add(testJson3);
        log.info("msg:{}", JSON.toJSONString(testJsonList));

        String s = "[{\"fieldA\":\"A1\",\"fieldB\":\"B1\"},{\"fieldA\":\"A3\",\"fieldB\":\"B3\"},{\"fieldA\":\"A2\",\"fieldB\":\"B2\"}]";
        final List<TestJson> testJsons = JSON.parseArray(s, TestJson.class);
        log.info("res:{}", testJsons);


    }

}
