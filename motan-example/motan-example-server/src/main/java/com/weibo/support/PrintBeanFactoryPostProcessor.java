package com.weibo.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Description:
 * @author: liukairong1
 * @date: 2023/05/31/10:36
 */
public class PrintBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();

    }
}
