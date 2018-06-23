package com.fk.memory.service.allocator;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.service.VariableBlock;
import com.fk.memory.service.allocator.Allocator;

public class ContinuousAllocator implements Allocator {
    public boolean allocate(MemoryAllocationRequest request, VariableBlock[] block) {
        for (int i = 0; i < block.length; i++) {
            if(block[i]==null) {
               if(isNblockAvailable(i, request.getBlocksRequired(), block)) {
                   finalizeAllocation(i, block, request);
                   return true;
               }
            }
        }
        return false;
    }

    private void finalizeAllocation(int start, VariableBlock[] block, MemoryAllocationRequest request) {
       VariableBlock variableBlock = new VariableBlock(request.getProcess(), request.getVariable());
        for (int i = start; i < start+request.getBlocksRequired(); i++) {
            block[i] = variableBlock;
        }
    }

    private boolean isNblockAvailable(int start, int blocksRequired, VariableBlock[] block) {
        boolean flag=true;
        for (int i = start; i < start+blocksRequired; i++) {
            if(block[i]!=null) {
                return false;
            }
        }
        return flag;
    }
}
