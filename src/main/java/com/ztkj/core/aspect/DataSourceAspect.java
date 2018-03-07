package com.ztkj.core.aspect;

import com.alibaba.druid.pool.DruidDataSource;
import com.ztkj.core.bean.DynamicDataSource;
import com.ztkj.core.entity.Response;
import com.ztkj.core.redis.RedisClientTemplate;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zero on 2016/5/31.
 */
@Aspect
@Component
public class DataSourceAspect {

    private static final Logger logger = Logger.getLogger(DataSourceAspect.class);

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    //这里设置切面
    @Pointcut("execution(public * com.ztkj.test.test.controller..*.*(..))")
    public void dsPointCut(){}

    /**
     *
     * @Title：doBeforeInServiceLayer
     * @Description: 方法调用前触发
     *  记录开始时间
     * @param joinPoint
     */
    @Before("dsPointCut()")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
    }

    /**
     *
     * @Title：doAfterInServiceLayer
     * @Description: 方法调用后触发
     *  记录结束时间
     * @param joinPoint
     */
    @After("dsPointCut()")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {

    }

    /**
     * @Title：doAround
     * @Description: 环绕触发
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("dsPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) {

        /**
         * 1.获取request信息
         * 2.根据request获取session
         * 3.从session中取出登录用户信息
         */
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();

        //这里应该是token
        String token = request.getHeader("token");

        try {
            if(token == null || token.equals("")){
                return Response.getErrorInstance(null,"Access denied!");
            }
            //判断token是否合法
            /**
             * 1.从redis中查询
             * 2.或者从数据库查询
             * 3.合法就设置数据源
             */
            Integer userId = Integer.parseInt(token);

            DruidDataSource druidDataSource = dynamicDataSource.getDataSource(userId);
            if(druidDataSource==null){
                return Response.getErrorInstance(null,"用户未配置数据源!");
            }else {
                dynamicDataSource.selectDataSource(userId);
            }

        }catch (Exception ex){
            logger.error("获取用户信息异常",ex);
            return Response.getErrorInstance(null,"Access denied!");
        }

        Object result = new Object();

        try {
            result = pjp.proceed();// result的值就是被拦截方法的返回值
        }catch (Throwable e){
            e.printStackTrace();
        }

        return result;

    }



}
