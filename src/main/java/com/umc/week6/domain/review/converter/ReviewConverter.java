package com.umc.week6.domain.review.converter;

import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.review.dto.ReviewRequest;
import com.umc.week6.domain.review.dto.ReviewRequest.AddReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.entity.Review;
import com.umc.week6.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewConverter {
    public Review toEntity(AddReviewRequest request, Member member, Store store) {
        return Review.builder()
                .id(null)
                .stars(request.getStars())
                .content(request.getContent())
                .member(member)
                .store(store)
                .build();
    }

    public ReviewId toReviewId(Long reviewId) {
        return ReviewId.builder()
                .reviewId(reviewId)
                .build();
    }
}
