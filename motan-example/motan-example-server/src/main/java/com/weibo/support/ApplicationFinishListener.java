package com.weibo.support;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: liukairong1
 * @date: 2023/05/31/10:31
 */
@Component
@Slf4j
public class ApplicationFinishListener implements ApplicationListener<ContextRefreshedEvent> {

    Joiner.MapJoiner joiner = Joiner.on("\n").withKeyValueSeparator(" : ");

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("{}", joiner.join(PrintBeanInfoBeanPostProcessor.beanMap));
    }
}
