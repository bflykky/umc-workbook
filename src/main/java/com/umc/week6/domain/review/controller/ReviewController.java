package com.umc.week6.domain.review.controller;

import com.umc.week6.domain.review.dto.ReviewRequest;
import com.umc.week6.domain.review.dto.ReviewRequest.AddReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.service.ReviewService;
import com.umc.week6.global.result.ResultResponse;
import com.umc.week6.global.result.code.ReviewResultCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.week6.global.result.code.ReviewResultCode.ADD_REVIEW;

@RequestMapping("/reviews")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResultResponse<ReviewId> addReview(@Valid @RequestBody AddReviewRequest request) {
        return ResultResponse.of(ADD_REVIEW, reviewService.addReview(request));
    }
}
