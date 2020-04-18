package SpringShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER")
public class Order {
    private Integer orderId;
    private User user;
    private Address address;
    private Product product;
    private Integer ammount;
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


    @ManyToOne
    @JoinColumn(name = "'userId'")
    public User getUser() {
        return user;
    }

    @OneToOne
    @JoinColumn(name = "[addressId]")
    public Address getAddress() {
        return address;
    }

    @OneToOne
    public Product getProduct() {
        return product;
    }

    @Column(name = "Ammount")
    public Integer getAmmount() {
        return ammount;
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

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}



