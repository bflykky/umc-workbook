package com.umc.week6.global.error;

import org.springframework.http.HttpStatus;

/**
 * 에러 코드에 대한 class
 * 에러 코드 형식
 * 1. 모든 에러 코드는 "E"로 시작한다.
 * 2. 2번째 문자는 에러가 발생한 카테고리를 나타낸다.
 * ex) "M": Member, "MS": Mission, "TM": TryingMission, "R": Review
 */
public interface ErrorCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
