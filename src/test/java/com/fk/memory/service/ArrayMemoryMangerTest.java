package com.fk.memory.service;

import com.fk.memory.pojo.MemoryAllocationRequest;
import com.fk.memory.pojo.MemoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class ArrayMemoryMangerTest {

    @Test
    public void allocateVeryHigh() {
        MemoryManger memoryManger = new ArrayMemoryManger(100);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",1000, false));
        log.info("allocation: " + response);
    }

    @Test
    public void allocateStreamOfBlock() {
        MemoryManger memoryManger = new ArrayMemoryManger(10);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",5, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_y",5, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_z",5, true));
        log.info("allocation: " + response);
    }

    @Test
    public void defaultTestCase() {
        MemoryManger memoryManger = new ArrayMemoryManger(100);
        MemoryResponse response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",1000, false));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_x",10, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P2","var_y",25, true));
        log.info("allocation: " + response);
        response = memoryManger.free("P1", "var_x");
        log.info("allocation: " + response);
        response = memoryManger.kill("P2");
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_z",10, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P4","var_x",5, true));
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_w",5, true));
        log.info("allocation: " + response);
        response = memoryManger.free("P4", "var_x");
        log.info("allocation: " + response);
        response = memoryManger.allocate(new MemoryAllocationRequest("P1","var_y",6, false));
        log.info("allocation: " + response);
        Map<String,List<Integer>> inspectResponse = memoryManger.inspect("P1");
        log.info(inspectResponse.toString());
    }
}