package com.globaldenso.dnkr;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * Json 타입 문자열을 화면 출력 용 Class
 * @author $Author$
 * @version $Revision$
 */
public class JsonView extends AbstractView{
    /** Constructor.    */
    public JsonView() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, 
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write((String) model.get("jsonString"));
        writer.close();

    }

}
