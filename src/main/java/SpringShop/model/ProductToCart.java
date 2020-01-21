package SpringShop.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ProductsToCart")
public class ProductToCart {
    private Integer productToCartId;
    private Product product;
    private Integer quantity;

    public ProductToCart() {
    }

    public ProductToCart(Integer productToCartId, Product product, Integer quantity) {
        this.productToCartId = productToCartId;
        this.product = product;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @NotNull
    public Integer getProductToCartId() {
        return productToCartId;
    }


    @OneToOne
    @JoinColumn(name = "productId")
    public Product getProduct() {
        return product;
    }

    @NotNull
        public Integer getQuantity() {
            return quantity;
    }

    public void setProductToCartId(Integer productToCartId) {
        this.productToCartId = productToCartId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
