package com.umc.week6.domain.review.repository;

import com.umc.week6.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByStoreId(Long storeId, Pageable pageable);
    Page<Review> findByMemberId(Long memberId, Pageable pageable);

}
