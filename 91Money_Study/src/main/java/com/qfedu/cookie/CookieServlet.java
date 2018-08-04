package com.qfedu.cookie;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Bingove
 * @Date 2018/7/25 0025 下午 18:40
 */
@WebServlet("/cookie.do")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("type").equals("r")) {
            getCk(req);
        } else {
            writCK(resp);
        }
    }
    //获取cookie
    public void getCk(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies
             ) {
            System.out.println(c.getName() + "-----" + c.getMaxAge() + "--" + c.getValue());
        }
    }
    //设置cookie
    public void writCK(HttpServletResponse response) {
        Cookie cookie = new Cookie("username","cdj12345");
        cookie.setMaxAge(60); //60s
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
