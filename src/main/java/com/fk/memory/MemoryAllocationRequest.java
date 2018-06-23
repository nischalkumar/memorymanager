package com.fk.memory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemoryAllocationRequest {
    private final    String process;
    private final    String variable;
    private final    int blocksRequired;
    private final    boolean conitnous;
}
