package com.umc.week6.domain.review.service;

import com.umc.week6.domain.review.dto.ReviewRequest.AddReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse.PagedReviewInfo;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;

public interface ReviewService {
    ReviewId addReview(AddReviewRequest request);
    PagedReviewInfo findReviewListByStoreId(Long storeId, Integer page);
    PagedReviewInfo findMyReviewList(Long memberId, Integer page);
}
