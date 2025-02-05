package jpabasic.datepickproject.address;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabasic.datepickproject.common.entity.user.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, AddressRepositoryCustom {
}
