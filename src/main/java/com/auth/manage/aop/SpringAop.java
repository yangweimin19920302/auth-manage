package com.auth.manage.aop;

import com.auth.manage.util.CustomException;
import com.auth.manage.util.ResultUtil;
import com.auth.starter.exception.ConnectErrorException;
import com.auth.starter.exception.NoPermissionException;
import com.auth.starter.exception.OutOfDateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAop {

    /**
     * 环绕通知
     * value = "execution(* com.china.user.project.controller.*.*(..))"第一个*比表示方法的类型以及返回的类型
     *
     * @param pjp 连接点
     */
    @Around(value = "execution(Object com.auth.manage.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return new ResultUtil(true, 200, pjp.proceed());
        } catch (CustomException e) {
            e.printStackTrace();
            return new ResultUtil(false, e.getCode(), e.getMessage());
        }catch (OutOfDateException e) {
            e.printStackTrace();
            return new ResultUtil(false, 300, e.getMessage());
        } catch (NoPermissionException e) {
            e.printStackTrace();
            return new ResultUtil(false, 206, e.getMessage());
        } catch (ConnectErrorException e) {
            e.printStackTrace();
            return new ResultUtil(false, 207, e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return new ResultUtil(false, 400, "系统异常");
        }
    }
}
