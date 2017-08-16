package com.magicbeans.web.qiniuyun;

import com.google.gson.Gson;
import com.magicbeans.config.QiNiuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
@Component
public class QiNiuUpload {
    @Autowired
    private QiNiuConfig qiNiuConfig;
//    private String accessKey = qiNiuConfig.getAccessKey();
//    private String secretKey = qiNiuConfig.getSecretKey();
//    private String bucket = qiNiuConfig.getBucket();
    private String accessKey = "6MmJ1fhj2RsY81AyPbBWMDIaW8Retqhd-kyGR36i";
    private String secretKey = "gufQz3rlFBGawHSeHEoP5_XOSbJY8BcSe34mzipJ";
    private String bucket = "test";
    /**
     *
     * @param localFilePath 如果是Windows情况下，格式是 D:\\qiniu\\test.png
     */
    public void uploadFile(String localFilePath){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.huanan());
        //...其他参数参考类注释

        //...生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
        try {
            //设置断点续传文件进度保存目录
            FileRecorder fileRecorder = new FileRecorder(localTempDir);
            UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
            try {
                Response response = uploadManager.put(localFilePath, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
