package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;

public interface Allocator {
    boolean allocate(MemoryAllocationRequest request, VariableBlock block[]);
}
