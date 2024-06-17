package com.umc.week6.domain.review.service;

import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.member.service.MemberService;
import com.umc.week6.domain.review.converter.ReviewConverter;
import com.umc.week6.domain.review.dto.ReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.entity.Review;
import com.umc.week6.domain.review.repository.ReviewRepository;
import com.umc.week6.domain.store.entity.Store;
import com.umc.week6.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final MemberService memberService;
    private final StoreService storeService;
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    @Transactional
    @Override
    public ReviewId addReview(ReviewRequest.AddReviewRequest request) {
        Member member = memberService.getMember(request.getMemberId());
        Store store = storeService.getStore(request.getStoreId());

        Review review = reviewConverter.toEntity(request, member, store);
        reviewRepository.save(review);
        return reviewConverter.toReviewId(review.getId());
    }
}
