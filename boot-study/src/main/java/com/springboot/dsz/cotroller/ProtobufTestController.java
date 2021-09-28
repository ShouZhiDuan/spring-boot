package com.springboot.dsz.cotroller;

import com.springboot.dsz.proto_dto.MessageOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
          order.setName("订单名称");
          order.setCount("订单数量");
          MessageOrder.Order build = order.build();
          return build;
    }

}
