package com.alibaba.learning.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@Slf4j
//@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(CustomException.class)
//    public ModelAndView defaultExceptionHandler(HttpServletRequest req, Exception e) {
//        log.error("----------捕捉到全局异常,", e);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("url", req.getRequestURL());
//        mv.addObject("exception", e);
//        mv.setViewName("error");
//        return mv;
//    }
//
//    @ExceptionHandler(value = CustomException.class)
//    @ResponseBody
//    public CustomResult jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception {
//
//        //TODO 错误日志处理
//
//        return CustomResult.fail(e.getMessage(), "some data");
//    }


}
