package com.rainbow.commons.util;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 功能描述:根据UUID生成keep值 用于日志打印的
 * Created by Admin on 2016-07-06 21:28.
 */
public class ThreadLocalUtil {

    private static final ThreadLocal<String> seq = new ThreadLocal<String>();

    public static final ThreadLocalUtil getInstance() {
        return new ThreadLocalUtil();
    }

    public String getKeep() {
        String seqStr = seq.get();
        if (StringUtils.isEmpty(seqStr)) {
            seqStr = getUUID();
            seq.set(seqStr);
        }
        return seqStr;
    }

    public void setKeep(String keep) {
        if (!StringUtils.isEmpty(keep)) {
            seq.set(keep);
        } else {
            seq.set(getUUID());
        }
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
