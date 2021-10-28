package com.zs.filter;

import com.zs.entity.Token;
import com.zs.service.TokenService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter("/*")
public class TokenFilter implements Filter {

    private TokenService tokenService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();//这里获取applicationContext
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        tokenService = (TokenService) ctx.getBean(TokenService.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //会话跟踪和验证
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        //ServletContext context = req.getServletContext();

        //获取请求头中的token字符串
        String tokenString = req.getHeader("token");
        String respToken = "";

        //没有token（第一次请求）
        if (tokenString == null) {
            //生成token
            Token token = new Token();
            token.setToUuid(UUID.randomUUID().toString());

//context.setAttribute(token.getToUuid(), token);
            //存到数据库token表
            tokenService.insert(token);

            respToken = token.getToUuid();
        } else {
            //验证token是否过期
//Token token = (Token) context.getAttribute(tokenString);
            Token token = tokenService.queryByUUId(tokenString);

            if (token == null) {
                //重新生成token（新会话）
                token = new Token();
                token.setToUuid(UUID.randomUUID().toString());
//context.setAttribute(token.getToUuid(), token);
                //存到数据库token表
                tokenService.insert(token);
            }
            respToken = token.getToUuid();
        }
        //把token绑定到请求对象里面，后面login的Servlet通过请求对象获取。
        req.setAttribute("token",respToken);
        resp.setHeader("token", respToken);
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
