package com.umc.week6.domain.review.controller;

import com.umc.week6.domain.review.controller.validation.CheckPage;
import com.umc.week6.domain.review.dto.ReviewRequest.AddReviewRequest;
import com.umc.week6.domain.review.dto.ReviewResponse;
import com.umc.week6.domain.review.dto.ReviewResponse.PagedReviewInfo;
import com.umc.week6.domain.review.dto.ReviewResponse.ReviewId;
import com.umc.week6.domain.review.service.ReviewService;
import com.umc.week6.global.result.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.week6.global.result.code.ReviewResultCode.ADD_REVIEW;
import static com.umc.week6.global.result.code.ReviewResultCode.STORE_REVIEW_LIST;

@RequestMapping("/reviews")
@Tag(name = "가게 리뷰 API", description = "가게 리뷰 관련 API입니다.")
@Validated
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @Operation(summary = "새 가게 리뷰 작성 API", description = "특정 가게에 대하여 새 리뷰를 작성합니다.")
    public ResultResponse<ReviewId> addReview(@Valid @RequestBody AddReviewRequest request) {
        return ResultResponse.of(ADD_REVIEW, reviewService.addReview(request));
    }

    @GetMapping
    @Parameters(value = {
            @Parameter(name = "storeId", description = "리뷰를 조회할 가게의 storeId를 입력해 주세요."),
            @Parameter(name = "page", description = "page 시작은 0번부터입니다."),
    })
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "storeId를 이용해 특정 가게의 리뷰 목록을 조회합니다.")
    public ResultResponse<PagedReviewInfo> findReviewListByStoreId(@RequestParam("storeId") Long storeId,
                                                                   @CheckPage @RequestParam("page") Integer page) {
        return ResultResponse.of(STORE_REVIEW_LIST, reviewService.findReviewListByStoreId(storeId, page));
    }
}
