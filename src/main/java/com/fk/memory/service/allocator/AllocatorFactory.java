package com.fk.memory.service.allocator;

import com.fk.memory.pojo.MemoryAllocationRequest;

public class AllocatorFactory {
    private final static Allocator continousAllocator = new ContinuousAllocator();
    private final static Allocator randomAllocator= new RandomAllocator();

    public Allocator getInsance(MemoryAllocationRequest request) {
        if(request.isContinuous()) return continousAllocator;
        return randomAllocator;
    }
}
