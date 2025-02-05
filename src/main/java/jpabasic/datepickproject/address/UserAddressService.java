package jpabasic.datepickproject.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jpabasic.datepickproject.dto.user.response.UserResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAddressService {

	private final AddressRepository addressRepository;

	public Page<UserResponseDto> findUserAddress(String address, Pageable pageable) {
		return addressRepository.findAllUserByAddress(address, pageable);
	}
}
