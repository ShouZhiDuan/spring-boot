package com.springboot.dsz.cotroller;

import com.springboot.dsz.proto_dto.MessageOrder;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@RestController
@RequestMapping("/proto")
public class ProtobufTestController {

    @GetMapping(value = "/test", produces = "application/x-protobuf")
    public MessageOrder.Order getOrder(){
          MessageOrder.Order.Builder order = MessageOrder.Order.newBuilder();
          order.setName("牙膏");
          order.setCount("20支");
          MessageOrder.Order build = order.build();
          return build;
    }

    /**
     * PostMan测试文件
     * src/main/postman/order
     */
    @PostMapping(value = "test",  produces = "application/x-protobuf", consumes = "application/x-protobuf")
    public Object postOrder(@RequestBody MessageOrder.Order order){
        String name = order.getName();
        String count = order.getCount();
        return name + " : " + count;
    }

}
