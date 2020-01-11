package SpringShop;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
public final class Product {
    private Integer productId;
    private String productTitle;
    private String productDescription;
    private Integer productQuantity;
    private BigDecimal productPrice;

    public Product() {
    }

    public Product(String productTitle, String productDescription, Integer productQuantity, BigDecimal productPrice) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    @Id
    @GeneratedValue
    @NotNull
    public Integer getProductId() {
        return productId;
    }

    @NotNull
    public String getProductTitle() {
        return productTitle;
    }

    @NotNull
    public String getProductDescription() {
        return productDescription;
    }

    @NotNull
    public Integer getProductQuantity() {
        return productQuantity;
    }

    @NotNull
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
