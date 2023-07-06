package cn.crabapples.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("utf-8");
        Object userObj = request.getSession().getAttribute("user");
        Object sysUserObj = request.getSession().getAttribute("sysUser");
        String address = request.getRequestURI().replace(request.getContextPath(), "");
        log.info("请求拦截->请求地址:[{}]", address);
        if (address.startsWith("/manage")) {
            if (Objects.isNull(sysUserObj)) {
                response.sendRedirect(request.getContextPath() + "/manage/login");
                return false;
            }
            return true;
        }
        if (address.startsWith("/portal")) {
            if (Objects.isNull(userObj)) {
                response.sendRedirect(request.getContextPath() + "/portal/login");
                return false;
            }
            return true;
        }
//        if (address.startsWith("/api") && ) {
//            if (Objects.isNull(sysUserObj)) {
//                throw new ApplicationException("登录已失效，请重新登录");
//            }
//        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
    }

}
