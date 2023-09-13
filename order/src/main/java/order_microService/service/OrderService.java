package order_microService.service;

import lombok.RequiredArgsConstructor;
import order_microService.dto.OrderLineItemDTO;
import order_microService.dto.OrderRequest;
import order_microService.model.Order;
import order_microService.model.OrderItem;
import order_microService.repository.OrderRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepo orderRepo;
    public void placeOrder(@RequestBody OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItem> orderItems = orderRequest.getOrderLineItemsDTOList()
                .stream()
                .map(this::mapToDTO)
                .toList();

        order.setOrderItemList(orderItems);
        orderRepo.save(order);
    }

    private OrderItem mapToDTO(OrderLineItemDTO orderLineItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderLineItemDTO.getId());
        orderItem.setSkuCode(orderLineItemDTO.getSkuCode());
        orderItem.setPrice(orderLineItemDTO.getPrice());
        orderItem.setQuantity(orderLineItemDTO.getQuantity());

        return orderItem;
    }
}
