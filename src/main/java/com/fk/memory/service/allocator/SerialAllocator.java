package com.fk.memory.service.allocator;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.service.VariableBlock;
import com.fk.memory.service.allocator.Allocator;

public class SerialAllocator implements Allocator {
    public boolean allocate(MemoryAllocationRequest request, VariableBlock[] block) {
        VariableBlock variableBlock = new VariableBlock(request.getProcess(),request.getProcess());
        for (int i = 0; i < block.length; i++) {
            if(block[i]==null) {
                block[i] = variableBlock;
            }
        }
        return true;
    }
}
