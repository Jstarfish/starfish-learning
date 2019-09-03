package com.qihoo.dmp.southernAirlines.bo;

import com.qihoo.dmp.southernAirlines.bo.StandardProductStruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:53
 * @description:
 */
public class StandardProductStructStorage {
    public String flag;
    public List<StandardProductStruct> standardProductStructs = new ArrayList<StandardProductStruct>();

    public StandardProductStructStorage(String flag) {
        this.flag = flag;
    }

    public void addStandardProductStruct(StandardProductStruct e) {
        standardProductStructs.add(e);
    }

    public int size() {
        return standardProductStructs.size();
    }

    public void clear() {
        standardProductStructs.clear();
    }
}

