package com.fk.memory.service.allocator;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.service.VariableBlock;
import com.fk.memory.service.allocator.Allocator;

public class RandomAllocator implements Allocator {
    public boolean allocate(MemoryAllocationRequest request, VariableBlock[] block) {
        throw new UnsupportedOperationException();
    }
}
