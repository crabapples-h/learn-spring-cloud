package cn.crabapples.common.base;

import cn.crabapples.common.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 基础Controller
 */
public abstract class BaseController {
    @Autowired
    private Validator validator;

    /**
     * 属性校验的方法
     *
     * @param object 需要验证的对象
     */
    protected final void valid(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            throw new ApplicationException(constraintViolation.getMessageTemplate());
        }
    }
}
