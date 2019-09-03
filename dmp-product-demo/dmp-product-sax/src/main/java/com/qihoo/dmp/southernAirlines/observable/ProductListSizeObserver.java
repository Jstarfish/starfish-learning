package com.qihoo.dmp.southernAirlines.observable;

import com.qihoo.dmp.southernAirlines.bo.StandardProductStructStorage;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:53
 * @description:
 */
public class ProductListSizeObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof StandardProductStructStorage) {
            StandardProductStructStorage productStructStorage = (StandardProductStructStorage) arg;
            XmlGenerator xmlGenerator = new XmlGenerator(productStructStorage.flag);
            xmlGenerator.buildXml(productStructStorage.standardProductStructs);
            productStructStorage.clear();
        }
    }

}
