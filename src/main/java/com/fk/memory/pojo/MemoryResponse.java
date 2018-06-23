package com.fk.memory.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class MemoryResponse {
    private final    ResponseCode responseCode;
    private final    int memoryAllocated;
    private final    int memoryLeft;
}
