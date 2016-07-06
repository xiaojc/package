package com.rainbow.commons.util;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.management.ManagementFactory;

/**
 * 功能描述:记录系统的pid
 * Created by Admin on 2016-07-06 21:34.
 */
@Slf4j
public class PIDConvert extends ClassicConverter {
    public static String PID;

    static {
        try {
            //在应用启动的时候获取当前应用进程ID
            String name = ManagementFactory.getRuntimeMXBean().getName();
            PID = name.split("@")[0];
            //如果没拿到。默认赋值-1
            if (StringUtils.isEmpty(PID)) {
                PID = "-1";
            }
        } catch (Exception e) {
            log.error(Throwables.getStackTraceAsString(e));
        }
    }

    @Override
    public String convert(ILoggingEvent event) {
        return PID;
    }
}
