package jpabasic.datepickproject.common.entity.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS",indexes = {@Index(name = "address_index",columnList = "user_id, address")})
// @Table(indexes = {@Index(name = "member_index",columnList = "member_id")})
@Getter
@NoArgsConstructor
public class Address {
	@Comment("유저 식별자")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT")
	private Long id;

	@Column(
		name = "address",
		nullable = false
	)
	private String address;

	@CreatedDate
	@Column(
		name = "createdAt",
		updatable = false
	)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(
		name = "lastModifiedAt",
		updatable = true
	)
	private LocalDateTime lastModifiedAt;

	@Column(
		name = "isReservation",
		nullable = false
	)
	private Boolean isReservation = true;

	@Column(
		name = "place_type",
		nullable = false
	)
	private String placeType;

	@Column(
		name = "place_name",
		nullable = false
	)
	private String placeName;

	@Column(
		name = "postal_code",
		nullable = false
	)
	private String postalCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
