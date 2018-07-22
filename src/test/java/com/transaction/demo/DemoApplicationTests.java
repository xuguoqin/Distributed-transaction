package com.transaction.demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testFastJson() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("aa", 123L);
        String json = JSONObject.toJSONString(map);
        Map<String, Object> map2 = (Map) JSONObject.parse(json);
        System.out.println(map2.get("aa"));
    }

}
