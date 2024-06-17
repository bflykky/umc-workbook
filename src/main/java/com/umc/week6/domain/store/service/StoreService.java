package com.umc.week6.domain.store.service;

import com.umc.week6.domain.store.dto.StoreRequest.RegisterStoreRequest;
import com.umc.week6.domain.store.dto.StoreResponse.StoreId;

public interface StoreService {
    StoreId registerStore(RegisterStoreRequest request);
}
