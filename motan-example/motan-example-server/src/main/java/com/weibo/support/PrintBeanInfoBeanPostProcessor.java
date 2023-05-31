package com.weibo.support;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @author: liukairong1
 * @date: 2023/05/31/10:20
 */
@Slf4j
@Component
public class PrintBeanInfoBeanPostProcessor implements BeanPostProcessor {

    public static Map<String, String> beanMap = Maps.newConcurrentMap();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        beanMap.put(beanName, bean.getClass().getName());
        return bean;
    }
}
