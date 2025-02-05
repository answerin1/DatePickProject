package jpabasic.datepickproject.address;

import static jpabasic.datepickproject.common.entity.user.QAddress.*;
import static jpabasic.datepickproject.common.entity.user.QUser.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jpabasic.datepickproject.dto.user.response.UserResponseDto;

public class AddressRepositoryCustomImpl implements AddressRepositoryCustom {
	private final JPAQueryFactory jpaQueryFactory;
	public AddressRepositoryCustomImpl(EntityManager entityManager) {
		this.jpaQueryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public Page<UserResponseDto> findAllUserByAddress(String address, Pageable pageable) {
		List<UserResponseDto> content = jpaQueryFactory.select(Projections.constructor(UserResponseDto.class,
				user.id,
				user.userName,
				address1.address,
				address1.createdAt,
				address1.lastModifiedAt,
				address1.isReservation,
				address1.placeType,
				address1.placeName,
				address1.postalCode
			))
			.from(address1)
			.join(address1.user,user)
			.where(address1.address.eq(address))
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch(); // fetch를 해야 조회가 가능해짐

		JPAQuery<Long> queryCount = jpaQueryFactory.select(address1.count())
			.from(address1)
			.where(address1.address.eq(address));

		return PageableExecutionUtils.getPage(content, pageable, queryCount::fetchOne);
	}
}
