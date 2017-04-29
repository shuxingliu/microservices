/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.DEBUG_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import org.springframework.stereotype.Component;

/**
 *
 * @author darren.shuxing.liu
 */
@Component
public class BookingCarRoutingFilter extends ZuulFilter{
    @Value("${unauthorized.url.redirect:http://www.sina.com.cn}")
    private String urlRedirect;
    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(BookingCarRoutingFilter.class.getName());
    
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
        return ROUTE_TYPE;
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
        return true;
    }
    
    /**
     * 请求是否通过认证.
     *
     * @param request 提供的请求
     *
     * @return true：提供的请求经过认证，否则为false
     */
    private boolean isAuthorizedRequest(RequestContext ctx) {        
        // 应用自己的过滤器
        return false;
    }

    /**
     * This method allows to set the route host into the Zuul request context provided as parameter.
     * The url is extracted from the orginal request and the host is extracted from it.
     *
     * @param ctx Zuul的请求上下文
     *
     * @throws MalformedURLException
     */
    private void setRouteHost(RequestContext ctx) throws MalformedURLException {

        String urlS = ctx.getRequest().getRequestURL().toString();
        URL url = new URL(urlS);
        String protocol = url.getProtocol();
        String rootHost = url.getHost();
        int port = url.getPort();
        String portS = (port > 0 ? ":" + port : "");
        ctx.setRouteHost(new URL(protocol + "://" + rootHost + portS));

    }

    /**
     * The filter execution
     *
     * @return
     */
    @Override
    public Object run() {

        // 记录拦截信息
        logger.info("query interception");

        // 获取Zuul的请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();

        try {

            // if the requested url is authorized, the route host is set to the requested one
            if (isAuthorizedRequest(ctx)) {
                setRouteHost(ctx);
            } else {
                // if the requested URL is not authorized, the route host is set to the urlRedirect value
                // the client will be redirected to the new host
               ctx.setRouteHost(new URL(urlRedirect));
            }
        } catch (MalformedURLException e) {
            logger.info("error happened when routing request");
        }

        return null;
    }
    
    private String decode(String token) {
        byte[] decodedBytes = Base64.getDecoder().decode(token.getBytes());
        //byte[] encodedBytes = Base64.getEncoder().encode(origin.getBytes());
        return new String(decodedBytes);
    }
}
