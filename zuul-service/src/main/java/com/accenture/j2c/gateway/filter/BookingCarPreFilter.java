/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.DEBUG_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORWARD_TO_KEY;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;
import org.springframework.stereotype.Component;

/**
 *
 * @author darren.shuxing.liu
 * Zuul的过滤功能，要重写虚拟函数filterType, filterOrder, run, shouldFilter
 */
@Component
public class BookingCarPreFilter extends ZuulFilter {
    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(BookingCarPreFilter.class.getName());
    
    /**
     * 过滤类型
     *pre：路由之前
     *routing：路由之时
     *post： 路由之后
     *error：发送错误调用
     * @return String
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }
    
    @Override
    public int filterOrder() {
        return DEBUG_FILTER_ORDER;
    }
    
    /*
    *是否需要过滤
    */
    @Override
    public boolean shouldFilter() {
        /*
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
                && !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId
        */
        return true;
    }
    
    /*
    *过滤规则
    */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            logger.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        logger.info("ok");
        return null;
    }
}
