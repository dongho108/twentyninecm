package kr.co._29cm.homework.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItems {

    private List<OrderItem> orderItems;

    private OrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static OrderItems from(final List<CartProduct> cartProducts) {
        validateCartProducts(cartProducts);
        return new OrderItems(mapToOrderItems(cartProducts));
    }

    private static void validateCartProducts(final List<CartProduct> cartProducts) {
        if (cartProducts == null) {
            throw new IllegalArgumentException("장바구니 상품들이 null 이면 주문목록을 생성할 수 없습니다.");
        }
        if (cartProducts.size() == 0) {
            throw new IllegalArgumentException("장바구니 상품들이 하나도 없으면 주문목록을 생성할 수 없습니다.");
        }
    }

    private static List<OrderItem> mapToOrderItems(final List<CartProduct> cartProducts) {
        return cartProducts.stream()
                .map(OrderItem::of)
                .collect(Collectors.toList());
    }

    public BigDecimal calculateAmount() {
        BigDecimal sum = BigDecimal.ZERO;
        for (final OrderItem orderItem : orderItems) {
            sum = sum.add(orderItem.getAmount());
        }
        return sum;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void reduceStock(final List<Product> products) {
        orderItems.forEach(orderItem -> products.forEach(product -> reduceStockByOrderItem(product, orderItem)));
    }

    private void reduceStockByOrderItem(final Product product, final OrderItem orderItem) {
        if (orderItem.isThisProduct(product)) {
            product.reduceStock(orderItem.getQuantity());
        }
    }
}
