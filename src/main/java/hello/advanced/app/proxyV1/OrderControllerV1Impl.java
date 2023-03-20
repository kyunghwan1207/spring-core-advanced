package hello.advanced.app.proxyV1;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderControllerV1Impl implements OrderControllerV1 {

    private final OrderServiceV1 orderService;

    @Autowired
    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return itemId;
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
