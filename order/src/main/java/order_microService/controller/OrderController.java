package order_microService.controller;

import lombok.RequiredArgsConstructor;
import order_microService.dto.OrderRequest;
import order_microService.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully.";
    }

//    _______ To be added later _______
//    @GetMapping("/list")
//    @ResponseStatus(HttpStatus.OK)
//    public String getOrderList(@RequestBody OrderListRequest orderListRequest) {
//        orderService.getOrderList(orderListRequest);
//    }
}
