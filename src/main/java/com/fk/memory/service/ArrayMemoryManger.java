package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import com.fk.memory.pojo.ResponseCode;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class ArrayMemoryManger implements MemoryManger{
    private final int size;
    private final VariableBlock block[];
    int left;
    private final AllocatorFactory allocatorFactory;
    public ArrayMemoryManger(int size) {
        this.size = size;
        this.block = new VariableBlock[size];
        this.left = size;
        this.allocatorFactory = new AllocatorFactory();
    }

    public MemoryResponse allocate(MemoryAllocationRequest memoryAllocationRequest) {
        if(memoryAllocationRequest.getBlocksRequired()<= this.left
                && allocatorFactory.getInsance(memoryAllocationRequest).allocate(memoryAllocationRequest,block)) {
            this.left = this.left-memoryAllocationRequest.getBlocksRequired();
            return new MemoryResponse(ResponseCode.SUCCESS, memoryAllocationRequest.getBlocksRequired(), this.left);
        }
        return new MemoryResponse(ResponseCode.ERROR, 0, this.left);
    }

    public MemoryResponse free(String process, String variable) {
        return null;
    }

    public MemoryResponse kill(String process) {
        return null;
    }

    public Map<String, List<Pair>> inspect(String process) {
        return null;
    }
}
