package com.dingpw.hornbook.api;

import com.alibaba.fastjson.JSON;
import com.dingpw.hornbook.ApplicationProperties;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 14:01.
 */
@Aspect
@Component
@Order(0)
public class ApiInputValidateAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiInputValidateAspect.class);
    private static HibernateValidatorConfiguration configuration = Validation
        .byProvider(HibernateValidator.class).configure();
    private static ValidatorFactory factory = configuration.failFast(true).buildValidatorFactory();

    @Pointcut("execution(* com.dingpw.hornbook.api..*.*(..)) && !execution(* com.dingpw.hornbook.api.test.TestController.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void apiInputPointcut() {
    }

    @Around("apiInputPointcut()")
    public void validateParam(ProceedingJoinPoint pjp) {
        ApiController target = (ApiController) pjp.getTarget();
        Object[] params = pjp.getArgs();
        try {
            if (params.length != 0 && params[0] != null) {
                String errorCode = valid(params[0]);
                if (errorCode == null) {
                    pjp.proceed();
                } else {
                    target.outputException(400);
                    String errorMessage = ApplicationProperties.apiBundles.get(target.getLocal())
                        .getString(errorCode);
                    LOGGER.info(
                        "invalidParams[" + errorMessage + "]:" + JSON.toJSONString(params) + " ");
                }
            } else {
                target.outputException(400);
            }
        } catch (Throwable th) {
            target.outputException(500);
            LOGGER.info(
                "invalidParams[unknown]:" + th.getMessage(), th);
        }
    }

    /**
     * 基于hibernate的参数校验
     */
    public static <E> String valid(E t) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(t);
        String errorMessage = null;
        if (null != constraintViolations && !constraintViolations.isEmpty()) {
            ConstraintViolation constraintViolation = (ConstraintViolation) constraintViolations
                .toArray()[0];
            errorMessage = constraintViolation.getMessage();
            return errorMessage;
        } else {
            return errorMessage;
        }
    }

}
