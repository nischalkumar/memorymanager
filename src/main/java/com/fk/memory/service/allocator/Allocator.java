package com.fk.memory.service.allocator;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.service.VariableBlock;

public interface Allocator {
    boolean allocate(MemoryAllocationRequest request, VariableBlock block[]);
}
