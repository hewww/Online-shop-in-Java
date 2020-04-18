package SpringShop.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
    private Integer addressId;
    private String city;
    private String country;
    private String street;
    private String zipcode;
    private User user;

    public Address() {
    }

    public Address(Integer addressId, String city, String country, String street, String zipcode) {
        this.addressId = addressId;
        this.city = city;
        this.country = country;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    public Integer getAddressId() {
        return addressId;
    }

    @NotNull
    public String getCity() {
        return city;
    }

    @NotNull
    public String getCountry() {
        return country;
    }

    @NotNull
    public String getStreet() {
        return street;
    }

    @NotNull
    public String getZipcode() {
        return zipcode;
    }

    @OneToOne
    public User getUser() {
        return user;
    }


    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setUser(User user) {
        this.user=user;
    }

}
