package com.umc.week6.domain.review.converter;

import com.umc.week6.domain.member.converter.MemberConverter;
import com.umc.week6.domain.member.dto.MemberResponse;
import com.umc.week6.domain.member.dto.MemberResponse.MemberInfo;
import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.review.dto.ReviewRequest;
import com.umc.week6.domain.review.dto.ReviewRequest.AddReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse;
import com.umc.week6.domain.review.dto.ReviewResponse.PagedReviewInfo;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewInfo;
import com.umc.week6.domain.review.entity.Review;
import com.umc.week6.domain.store.converter.StoreConverter;
import com.umc.week6.domain.store.dto.StoreResponse;
import com.umc.week6.domain.store.dto.StoreResponse.StoreInfo;
import com.umc.week6.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReviewConverter {
    private final MemberConverter memberConverter;
    private final StoreConverter storeConverter;
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

    public ReviewInfo toReviewInfo(Review review) {
        MemberInfo memberInfo = memberConverter.toMemberInfo(review.getMember());
        StoreInfo storeInfo = storeConverter.toStoreInfo(review.getStore());

        return ReviewInfo.builder()
                .reviewId(review.getId())
                .stars(review.getStars())
                .content(review.getContent())
                .memberInfo(memberInfo)
                .storeInfo(storeInfo)
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public PagedReviewInfo toPagedReviewInfo(Page<Review> reviews) {
        List<ReviewInfo> reviewInfoList = reviews.stream()
                .map(review -> toReviewInfo(review))
                .toList();

        return PagedReviewInfo.builder()
                .reviewInfoList(reviewInfoList)
                .page(reviews.getNumber())
                .totalPages(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .isFirst(reviews.isFirst())
                .isLast(reviews.isLast())
                .build();
    }
}
