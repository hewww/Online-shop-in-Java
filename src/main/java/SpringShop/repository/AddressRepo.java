package SpringShop.repository;

import SpringShop.model.Address;
import SpringShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Transactional
@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

    @Override
    List<Address> findAll();

    List<Address> findByAddressId(Integer id);

    @Override
    void deleteById(Integer addressId);


    @Override
    Address save(Address address);



}
