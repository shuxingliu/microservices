/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.gateway.filter;

import com.netflix.client.Utils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.DEBUG_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import org.springframework.stereotype.Component;
import java.util.Base64;

/**
 *
 * @author darren.shuxing.liu
 * Zuul的pre过滤功能，要重写虚拟函数filterType, filterOrder, run, shouldFilter
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
        //增加自己的判断
        return false;
    }
    
    /*
    *过滤规则
    */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();     
   
        Object userid = request.getParameter("userid");
        if(userid == null) {
            logger.info("user id is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("user id cann't be null");
            }catch (Exception e){}

            return null;
        }
        //鉴权不通过，返回
        if(!auth(userid.toString())) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(402);   
            try {
                ctx.getResponse().getWriter().write("User didn't pass authorization");
            }catch (Exception e){}
            return null; 
        }
            
        //鉴权通过后，将user id转为Token加入到Zuul的请求头
        String accesstoken = encode(userid.toString());
        logger.info(String.format("pre routing, token = {%s}", accesstoken));
        ctx.addZuulRequestHeader("Authorization", accesstoken);        

        logger.info("added token to zuul request");
        return null;
    }
    
    private String encode(String origin) {
        byte[] encodedBytes = Base64.getEncoder().encode(origin.getBytes());
        return new String(encodedBytes);
    }
    
    //可以在此增加自己的鉴权逻辑
    private boolean auth(String userid) {
        return true;
    }
            
}
