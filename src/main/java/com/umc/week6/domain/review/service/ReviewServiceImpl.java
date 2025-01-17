package com.umc.week6.domain.review.service;

import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.member.service.MemberService;
import com.umc.week6.domain.review.converter.ReviewConverter;
import com.umc.week6.domain.review.dto.ReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse.PagedReviewInfo;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.entity.Review;
import com.umc.week6.domain.review.repository.ReviewRepository;
import com.umc.week6.domain.store.entity.Store;
import com.umc.week6.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public PagedReviewInfo findReviewListByStoreId(Long storeId, Integer page) {
        // 해당 storeId를 가진 Store가 존재하는지 검증
        storeService.getStore(storeId);

        Page<Review> reviewList = reviewRepository.findByStoreId(storeId, PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt"));
        return reviewConverter.toPagedReviewInfo(reviewList);
    }

    @Override
    public PagedReviewInfo findMyReviewList(Long memberId, Integer page) {
        Member member = memberService.getMember(memberId);

        Page<Review> reviewList = reviewRepository.findByMemberId(member.getId(), PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt"));
        return reviewConverter.toPagedReviewInfo(reviewList);
    }
}
