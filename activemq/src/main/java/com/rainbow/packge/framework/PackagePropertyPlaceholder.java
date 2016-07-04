package com.rainbow.packge.framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 功能:
 * Created by Admin on 2016-07-04 22:02.
 */
public class PackagePropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private static Map<String, String> contextMap = new HashMap();

    public PackagePropertyPlaceholder() {
    }

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
//        log.info("加载配置文件开始...");
        StringBuilder sb = new StringBuilder();
        String _key = "";
        String value = "";
        Iterator i$ = props.keySet().iterator();

        while(i$.hasNext()) {
            Object key = i$.next();
            _key = key + "";
            value = props.get(key) + "";
            sb.append("[  " + key + "\t:\t" + value + "  ]\r\n");
            contextMap.put(_key, value);
        }
/*
        log.info(sb.toString());
        log.info("加载配置文件结束...");*/
    }

    public static String getStrPro(String key) {
        String val = (String)contextMap.get(key);
//        log.info("{}:{}", key, val);
        return StringUtils.isEmpty(val)?"":val;
    }

    public static int getIntPro(String key) {
        try {
            String e = (String)contextMap.get(key);
//            log.info("{}:{}", key, e);
            if(!StringUtils.isEmpty(e)) {
                return Integer.parseInt(e);
            }
        } catch (Exception var2) {
//            log.error(var2.getMessage());
        }

        return 0;
    }

}
