package jpabasic.datepickproject.controller.address;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpabasic.datepickproject.dto.user.response.UserResponseDto;
import jpabasic.datepickproject.address.UserAddressService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserAddressController {

	private final UserAddressService userAddressService;

	@GetMapping("/address")
	public Page<UserResponseDto> findUserAddress(@RequestParam String address,
		@RequestParam(defaultValue = "1") int page) {

		Pageable pageable = PageRequest.of(page-1, 10);
		return userAddressService.findUserAddress(address, pageable);
	}
}
