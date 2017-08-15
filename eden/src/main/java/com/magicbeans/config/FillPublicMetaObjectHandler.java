package com.magicbeans.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * Mybatis Plus 公共数据填充器
 */
public class FillPublicMetaObjectHandler extends MetaObjectHandler {

    private final static String CREATETIME = "createtime";
    private final static String UPDATETIME = "updatetime";
    private final static String ID = "id";

    public void insertFill(MetaObject metaObject) {
        Object idObject = metaObject.getValue(ID);
        Object createtimeObj = metaObject.getValue(CREATETIME);
        if (null == idObject) {
            metaObject.setValue(ID, IdWorker.getId() + "");
            System.out.print(metaObject.getValue(ID));
        }
        if (null == createtimeObj) {
            metaObject.setValue(CREATETIME, new Date());
        }

    }


    public void updateFill(MetaObject metaObject) {
        Object updatetimeObj = metaObject.getValue(UPDATETIME);
        if(null == updatetimeObj){
            metaObject.setValue(UPDATETIME, new Date());
        }

    }
}
