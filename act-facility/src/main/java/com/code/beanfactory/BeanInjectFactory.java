package com.code.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * spring bean 获取工具类
 * Created by 刘长申
 * on time 2017/6/10
 */
@org.springframework.stereotype.Component
public class BeanInjectFactory implements BeanFactoryAware{

    private BeanFactory beanFactory = null;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public Object getBean(String name){
        return beanFactory.getBean(name);
    }

    public Object getBean(Class name){
        return beanFactory.getBean(name);
    }
}
