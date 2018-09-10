package com.ktw.eos;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KtwFilter implements Filter {
    /*
     *  * 对Filter的整个生命周期了解的一个案例
     * 注意事项：
     * 1.实现Filter接口时导入的是javax.servlet.Filter包
     * 2.方法均有web服务器自动调用，不需我们手动调用
     * 3.init方法中一般写初始化参数，这里先不用，后面的例子再使用。
     * 4.destroy方法一般不需要写任何代码
     * 5.重写doFilter方法，可以写我们对拦截的请求和响应的处理动作。
     * 6.写完该类后配置filter，在web.xml中配置。
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("客户端的请求已经被拦截到！");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Max-Age", "1800");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,HEAD,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers",
                "Content-Type,X-Requested-With,Authorization,Accept,Origin,Access-Control,Access-Control-Request-Method,Access-Control-Request-Headers,User-Operation-InfoA,Last-Modified,X-Auth-Token");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
