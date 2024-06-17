package com.umc.week6.domain.store.controller;

import com.umc.week6.domain.store.dto.StoreRequest;
import com.umc.week6.domain.store.dto.StoreRequest.RegisterStoreRequest;
import com.umc.week6.domain.store.dto.StoreResponse;
import com.umc.week6.domain.store.dto.StoreResponse.StoreId;
import com.umc.week6.domain.store.service.StoreService;
import com.umc.week6.global.result.ResultResponse;
import com.umc.week6.global.result.code.StoreResultCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.week6.global.result.code.StoreResultCode.REGISTER_STORE;

@RequestMapping("/stores")
@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResultResponse<StoreId> registerStore(@Valid @RequestBody RegisterStoreRequest request) {
        return ResultResponse.of(REGISTER_STORE, storeService.registerStore(request));
    }
}
