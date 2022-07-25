package com.demo.handler;

import com.advance.sunrise.tool.datamask.IDataMaskHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 可以自定义脱敏规则
 * @author wanghl
 * @date 2022/7/25
 */
public class PhoneMaskHandler implements IDataMaskHandler {
    @Override
    public String mask(String data) {
        if (StringUtils.isEmpty(data)) {
            return "";
        } else {
            int len = data.length();
            return data.substring(0, 3) + "****" + data.substring(len - 4, len);
        }
    }
}
