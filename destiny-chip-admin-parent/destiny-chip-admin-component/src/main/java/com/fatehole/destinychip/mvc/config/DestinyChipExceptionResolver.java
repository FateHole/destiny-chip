package com.fatehole.destinychip.mvc.config;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.exception.AccessForbiddenException;
import com.fatehole.destinychip.exception.LoginAccountAlreadyInUserException;
import com.fatehole.destinychip.exception.LoginAccountAlreadyInUserForUpdateException;
import com.fatehole.destinychip.exception.LoginFailedException;
import com.fatehole.destinychip.util.DestinyChipUtil;
import com.fatehole.destinychip.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FateCat
 * @version 2020-10-06-19:40
 */

@ControllerAdvice
public class DestinyChipExceptionResolver {

    /**
     * 通用的异常处理器
     * @param viewName 处理异常后返回的视图名
     * @param exception 捕获到的异常类型
     * @param request 当前请求
     * @param response 当前响应
     * @return 是Ajax请求: null; 不是返回ModelAndView
     * @throws IOException 可能写不出去
     */
    private ModelAndView commonResolve(String viewName,
                                       Exception exception,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws IOException {

        // 判断当前是否为Ajax请求
        if (DestinyChipUtil.judgementRequestType(request)) {
            // 创建ResultEntity对象
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            // 创建gson对象并将ResultEntity转换为JSON字符串
            String json = new Gson().toJson(resultEntity);
            // 将JSON字符串返回给浏览器
            response.getWriter().write(json);
            // 由于上面已经返回了响应,所以就不提供视图
            return null;
        } else {
            // 如果不是Ajax请求，则创建ModelAndView对象
            ModelAndView modelAndView = new ModelAndView();
            // 将Exception对象保存到ModelAndView中
            modelAndView.addObject(DestinyChipConstant.ATTR_NAME_EXCEPTION, exception);
            // 设置视图名
            modelAndView.setViewName(viewName);
            return modelAndView;
        }
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        return commonResolve("system-error", exception, request, response);
    }

    /**
     * 处理登陆失败后抛出的异常
     */
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolveLoginFailedException(LoginFailedException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        return commonResolve("admin/admin-login", exception, request, response);
    }

    /**
     * 处理用户未登录，非法访问受保护资源所抛出的异常
     */
    @ExceptionHandler(value = AccessForbiddenException.class)
    public ModelAndView resolveAccessForbiddenException(AccessForbiddenException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        return commonResolve("admin/admin-login", exception, request, response);
    }

    /**
     * 处理用户注册时，用户名已被注册的异常
     */
    @ExceptionHandler(value = LoginAccountAlreadyInUserException.class)
    public ModelAndView resolveLoginAccountAlreadyInUserException(LoginAccountAlreadyInUserException exception,
                                                        HttpServletRequest request,
                                                        HttpServletResponse response) throws IOException {
        return commonResolve("admin/admin-add", exception, request, response);
    }

    /**
     * 处理用户信息更改时，用户名已被注册的异常
     */
    @ExceptionHandler(value = LoginAccountAlreadyInUserForUpdateException.class)
    public ModelAndView resolveLoginAccountAlreadyInUserForUpdateException(LoginAccountAlreadyInUserForUpdateException exception,
                                                                  HttpServletRequest request,
                                                                  HttpServletResponse response) throws IOException {
        return commonResolve("error/system-error", exception, request, response);
    }
}
