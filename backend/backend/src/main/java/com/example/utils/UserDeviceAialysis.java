package com.example.utils;

import cn.dev33.satoken.context.SaHolder;
import org.springframework.stereotype.Component;
import ua_parser.Client;
import ua_parser.Parser;

/**
 * @author null
 */
@Component
public class UserDeviceAialysis {
    public String parseUserAgent(String userAgent) {
        Parser parser = new Parser();
        Client client = parser.parse(userAgent);
        return client.os.family;
    }

}
