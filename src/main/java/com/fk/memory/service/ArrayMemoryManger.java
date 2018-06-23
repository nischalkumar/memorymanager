package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class ArrayMemoryManger implements MemoryManger{
    private final int size;

    public ArrayMemoryManger(int size) {
        this.size = size;
    }

    public MemoryResponse allocate(MemoryAllocationRequest memoryAllocationRequest) {
        return null;
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
