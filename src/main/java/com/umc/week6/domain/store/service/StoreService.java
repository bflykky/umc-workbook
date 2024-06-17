package com.umc.week6.domain.store.service;

import com.umc.week6.domain.store.dto.StoreRequest.RegisterStoreRequest;
import com.umc.week6.domain.store.dto.StoreResponse.StoreId;
import com.umc.week6.domain.store.entity.Store;

public interface StoreService {
    StoreId registerStore(RegisterStoreRequest request);
    Store getStore(Long storeId);
}
