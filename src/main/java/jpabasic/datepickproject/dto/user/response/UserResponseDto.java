package jpabasic.datepickproject.dto.user.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
	private Long userId;
	private String username;
	private String address;
	private LocalDateTime createAt;
	private LocalDateTime modifiedAt;
	private boolean isReservation;
	private String placeType;
	private String placeName;
	private String postalCode;

}
