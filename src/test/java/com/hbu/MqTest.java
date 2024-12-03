package com.hbu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @ClassName MqTest
 * @Description TODO
 * @Author awei
 * @Date 2024/12/3 14:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("name","awei");
        String queueName="simple.queue";
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","awei");
        stringStringHashMap.put("age","18");
        rabbitTemplate.convertAndSend(queueName,stringStringHashMap);
    }

}
