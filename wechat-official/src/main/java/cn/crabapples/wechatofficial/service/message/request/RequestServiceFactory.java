package cn.crabapples.wechatofficial.service.message.request;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 16:28
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Component
public class RequestServiceFactory implements ApplicationContextAware {
    private static volatile BeanFactory context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static RequestService getInstance(RequestTypeEnum type) {
        return context.getBean(type.clazz);
    }


}
