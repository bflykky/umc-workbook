package com.umc.week6.domain.review.dto;

import com.umc.week6.domain.member.dto.MemberResponse;
import com.umc.week6.domain.member.dto.MemberResponse.MemberInfo;
import com.umc.week6.domain.store.dto.StoreResponse;
import com.umc.week6.domain.store.dto.StoreResponse.StoreInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ReviewResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewId {
        private Long reviewId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewInfo {
        private Long reviewId;
        private int stars;
        private String content;
        private MemberInfo memberInfo;
        private StoreInfo storeInfo;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PagedReviewInfo {
        @Builder.Default
        private List<ReviewInfo> reviewInfoList = new ArrayList<>();
        private int page;
        private int totalPages;
        private long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
