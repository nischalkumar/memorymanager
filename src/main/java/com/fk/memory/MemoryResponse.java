package com.fk.memory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemoryResponse {
    private final    ResponseCode responseCode;
    private final    int memoryAllocated;
    private final    int memoryLeft;
}
