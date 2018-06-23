package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import static org.junit.Assert.*;

@Slf4j
public class ArrayMemoryMangerTest {

    @org.junit.Test
    public void allocate() {
        MemoryManger memoryManger = new ArrayMemoryManger(100);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",1000, false));
        log.info("allocation: " + response);
    }
}