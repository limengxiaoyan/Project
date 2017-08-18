package com.magicbeans.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class AliSMSUtil {
    //沙箱环境
//    private String URL = "https://gw.api.tbsandbox.com/router/rest";
//    private String appkey = "1024589674";
//    private String secret = "sandbox41b7b7ef5081bb74ca8a53c0c";

    //正式环境
    private String URL= "https://eco.taobao.com/router/rest";
    private String appkey = "24589674";
    private String secret = "bf5f19f41b7b7ef5081bb74ca8a53c0c";

    //发送短信验证码
    public void sendSmsNum(String phone){
        try {
            TaobaoClient client = new DefaultTaobaoClient(URL, appkey, secret);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsFreeSignName("黎梦");
            int num = (int) ((Math.random() * 9 + 1) * 1000);
            req.setSmsParamString("{\"var1\":\""+num+"\"}");
            req.setRecNum(phone);
            req.setSmsTemplateCode("SMS_86525066");
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    //发送短信通知
    public void sendSms(String phone){
        try {
            TaobaoClient client = new DefaultTaobaoClient(URL, appkey, secret);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsFreeSignName("黎梦");
            int num = (int) ((Math.random() * 9 + 1) * 1000);
            req.setSmsParamString("{\"var\":\""+num+"\"}");
            req.setRecNum(phone);
            req.setSmsTemplateCode("SMS_86695065");
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
