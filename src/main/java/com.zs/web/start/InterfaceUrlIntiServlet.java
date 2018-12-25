package com.zs.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * ClassName: InterfaceUrlIntiServlet
 *
 * @Description: 项目文件初始化
 * @author zs
 * @date 2018/11/15 Pm 3:20:00
 */
public class InterfaceUrlIntiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        InterfaceUrlInti.init();
    }

}