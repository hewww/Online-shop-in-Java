package SpringShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    private Integer cartId;
    private BigDecimal totalPrice;
    private List<ProductToCart> productsList;

    public Cart() {
        this.productsList = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    public Integer getCartId() {
        return cartId;
    }

    @NotNull
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @OneToMany
    @NotNull
    public List<ProductToCart> getProductsList() {
        return productsList;
    }



    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProductsList(List<ProductToCart> productsList) {
        this.productsList = productsList;
    }
}
