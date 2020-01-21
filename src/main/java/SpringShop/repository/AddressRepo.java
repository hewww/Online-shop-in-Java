package SpringShop.repository;

import SpringShop.model.Address;
import SpringShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AddressRepo extends JpaRepository<Address,Integer> {
    List<Address> findByUser(User user);
    List<Address> findByAddressId(Integer addressId);
}
