package jpabasic.datepickproject.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jpabasic.datepickproject.common.entity.user.User;
import jpabasic.datepickproject.repository.user.UserRepository;

// @RequiredArgsConstructor
@Service
public class TestService {
	private final UserRepository userRepository;

	public TestService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createMockingUsers() {
		for (int i = 0; i < 100_000; i++) {
			User user = new User(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "다빈비번"+i);
			userRepository.save(user);
		}

	}
}
