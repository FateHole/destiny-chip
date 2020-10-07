package com.fatehole.destinychip.mvc.interceptor;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author FateCat
 * @version 2020-10-07-20:18
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws RuntimeException {

        // 通过request对象获取Session对象
        HttpSession session = request.getSession();

        // 尝试从Session域中获取Admin对象
        Admin admin = (Admin) session.getAttribute(DestinyChipConstant.ATTR_LOGIN_NAME_ADMIN);

        // 判断Admin对象是否为null
        if (admin == null) {
            // 抛出异常
            throw new AccessForbiddenException(DestinyChipConstant.MESSAGE_ACCESS_FORBIDDEN);
        }

        // 如果不为空，就放行
        return true;
    }

}
