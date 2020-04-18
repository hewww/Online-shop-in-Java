package SpringShop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {

    private Integer productId;
    private String productName;
    private ProductsCategory productCategory;
    private String productDescription;
    private Integer productInStock;
    private BigDecimal productPrice;


    public Product() {
    }

    public Product(Integer productId, String productName, ProductsCategory productCategory, String productDescription, Integer productInStock, BigDecimal productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productInStock = productInStock;
        this.productPrice = productPrice;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "productId")
    public Integer getProductId() {
        return productId;
    }

    @NotEmpty(message = "Product Name is necessary")
    @Column(name = "name")
    public String getProductName() {
        return productName;
    }

    @NotNull(message = "Please choose the products category")
    @Column(name="category")
    public ProductsCategory getProductCategory() {
        return productCategory;
    }

    @NotNull(message = "Please add some description")
    @Column(name = "description")
    public String getProductDescription() {
        return productDescription;
    }

    @NotNull(message = "Please enter the products quntity")
    @Min(value = 1, message = "Minimal size of your products to sell is - 1")
    @Column(name = "quantity")
    public Integer getProductInStock() {
        return productInStock;
    }

    @NotNull
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(ProductsCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductInStock(Integer productInStock) {
        this.productInStock = productInStock;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
