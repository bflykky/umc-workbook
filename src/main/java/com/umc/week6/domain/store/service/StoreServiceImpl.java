package com.umc.week6.domain.store.service;

import com.umc.week6.domain.store.converter.StoreConverter;
import com.umc.week6.domain.store.dto.StoreRequest;
import com.umc.week6.domain.store.dto.StoreRequest.RegisterStoreRequest;
import com.umc.week6.domain.store.dto.StoreResponse;
import com.umc.week6.domain.store.entity.Store;
import com.umc.week6.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;

    @Transactional
    @Override
    public StoreResponse.StoreId registerStore(RegisterStoreRequest request) {
        Store store = storeConverter.toEntity(request);
        // 나중에는 동일한 가게인지 확인하기 위해 사업자번호나 상호 같은 거도 요청 데이터로 받아야 할 듯
        storeRepository.save(store);
        return storeConverter.toStoreId(store.getId());
    }
}
