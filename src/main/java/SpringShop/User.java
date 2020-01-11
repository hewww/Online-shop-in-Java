package SpringShop;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public final class User {
    private Integer userId;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String cityRegion;

    public User() {
    }

    public User(String username, String email, String phone, String address, String cityRegion) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityRegion = cityRegion;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "userId", unique = true)
    public Integer getUserId() {
        return userId;
    }

    @NotNull
    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @NotNull
    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    @NotNull
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    @NotNull
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    @NotNull
    @Column(name = "cityRegion")
    public String getCityRegion() {
        return cityRegion;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }
    private void setUsername(String username) {
        this.username = username;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    private void setPhone(String phone) {
        this.phone = phone;
    }
    private void setAddress(String address) {
        this.address = address;
    }
    private void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }
}
