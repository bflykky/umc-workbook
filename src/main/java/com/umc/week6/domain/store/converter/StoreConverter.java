package com.umc.week6.domain.store.converter;

import com.umc.week6.domain.store.dto.StoreRequest;
import com.umc.week6.domain.store.dto.StoreRequest.RegisterStoreRequest;
import com.umc.week6.domain.store.dto.StoreResponse.StoreId;
import com.umc.week6.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StoreConverter {
    public Store toEntity(RegisterStoreRequest request) {
        return Store.builder()
                .id(null)
                .name(request.getName())
                .region(request.getRegion())
                .build();
    }

    public StoreId toStoreId(Long storeId) {
        return StoreId.builder()
                .storeId(storeId)
                .build();
    }
}
