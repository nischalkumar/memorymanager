package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import com.fk.memory.pojo.ResponseCode;
import com.fk.memory.service.allocator.AllocatorFactory;

import java.util.ArrayList;
import java.util.HashMap;
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
            return new MemoryResponse(ResponseCode.SUCCESS, this.size-this.left, this.left);
        }
        return new MemoryResponse(ResponseCode.ERROR, this.size-this.left, this.left);
    }

    public MemoryResponse free(String process, String variable) {
        int freeCont=0;
        for (int i = 0; i < block.length; i++) {
            if(block[i]!=null && block[i].getProcess().equals(process) &&
                    block[i].getVariable().equals(variable)) {
                freeCont++;
                block[i]=null;
            }
        }
        this.left=this.left+freeCont;
        return new MemoryResponse(ResponseCode.SUCCESS,this.size-this.left, this.left);
    }

    public MemoryResponse kill(String process) {
        int freeCont=0;
        for (int i = 0; i < block.length; i++) {
            if(block[i]!=null && block[i].getProcess().equals(process)) {
                freeCont++;
                block[i]=null;
            }
        }
        this.left=this.left+freeCont;
        return new MemoryResponse(ResponseCode.SUCCESS,this.size-this.left, this.left);
    }

    public Map<String, List<Integer>> inspect(String process) {
        Map<String,List<Integer>> response= new HashMap<>();
        for (int i = 0; i < block.length; i++) {
            if(block[i]!=null && block[i].getProcess().equals(process)) {
                List<Integer> indexList = response.getOrDefault(block[i].variable,new ArrayList<>());
                indexList.add(i);
                response.put(block[i].getVariable(), indexList);
            }
        }
        return response;
    }
}
