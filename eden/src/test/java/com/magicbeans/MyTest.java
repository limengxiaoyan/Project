package com.magicbeans;

import com.magicbeans.util.AliSMSUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class MyTest {
    @Test
    public static void main(String[] args){
        AliSMSUtil aliSMSUtil = new AliSMSUtil();
//        aliSMSUtil.sendSmsNum("15390277282");
        aliSMSUtil.sendSms("15283044723");
    }
}
