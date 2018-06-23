package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import static org.junit.Assert.*;

@Slf4j
public class ArrayMemoryMangerTest {

    @org.junit.Test
    public void allocateVeryHigh() {
        MemoryManger memoryManger = new ArrayMemoryManger(100);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",1000, false));
        log.info("allocation: " + response);
    }

    @org.junit.Test
    public void allocateStreamOfBlock() {
        MemoryManger memoryManger = new ArrayMemoryManger(10);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",5, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_y",5, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_z",5, true));
        log.info("allocation: " + response);
    }
}