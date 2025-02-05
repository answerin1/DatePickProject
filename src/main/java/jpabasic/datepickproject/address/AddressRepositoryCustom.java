package jpabasic.datepickproject.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jpabasic.datepickproject.dto.user.response.UserResponseDto;

public interface AddressRepositoryCustom {
	Page<UserResponseDto> findAllUserByAddress(String address, Pageable pageable);
}
