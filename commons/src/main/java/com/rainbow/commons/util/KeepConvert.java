package com.rainbow.commons.util;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 功能描述:转换keep，日志打印keep值
 * Created by Admin on 2016-07-05 23:28.
 */
public class KeepConvert  extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return ThreadLocalUtil.getInstance().getKeep();
    }
}
