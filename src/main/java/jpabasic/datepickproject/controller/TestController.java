package jpabasic.datepickproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jpabasic.datepickproject.service.TestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

	private final TestService testService;

	@PostMapping("/test/mocking-users")
	public void createUsersMocking() {
		testService.createMockingUsers();
	}
}
