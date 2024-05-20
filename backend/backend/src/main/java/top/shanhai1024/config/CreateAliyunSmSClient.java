package top.shanhai1024.config;

import com.aliyun.dysmsapi20170525.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author null
 * 阿里云配置
 */
@Configuration

public class CreateAliyunSmSClient {

    @Value("${aliyun.accessKeyId}")
    private  String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private   String accessKeySecret;

    /**
     * 使用AK&SK初始化账号Client
     * @return Client
     * @throws Exception
     */
    @Bean()
    public Client aliyunSMSClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }


}
