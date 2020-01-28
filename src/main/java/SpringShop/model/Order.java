package SpringShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER")
public class Order {
    private Integer orderId;
    private Cart cart;
    private User user;
    private Address address;
    private BigDecimal totalPrice;
    private boolean isPayment;
    private boolean isSend;
    private boolean isDelivered;

    public Order() {
        isPayment = false;
        isDelivered = false;
        isSend = false;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "OrderId")
    public Integer getOrderId() {
        return orderId;
    }

    @OneToOne
    @JoinColumn(name = "[cartId]")
    public Cart getCart() {
        return cart;
    }

    @OneToOne
    @JoinColumn(name = "'userId'")
    public User getUser() {
        return user;
    }

    @OneToOne
    @JoinColumn(name = "[addressId]")
    public Address getAddress() {
        return address;
    }

    @Column(name = "totalPrice")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Column(name = "isPayment")
    public boolean isPayment() {
        return isPayment;
    }

    @Column(name = "isSend")
    public boolean isSend() {
        return isSend;
    }
    @Column(name = "isDelivered")
    public boolean isDelivered() {
        return isDelivered;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}



