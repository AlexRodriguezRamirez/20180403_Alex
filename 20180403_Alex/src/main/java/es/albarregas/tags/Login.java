/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tags;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
/**
 *
 * @author Alex
 */
public class Login extends TagSupport {
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        
        try {
            out.write("<div class='login'>");
            out.write("<table><tr><td>User: </td><td><input type='text' name='user'></td></tr>");
            out.write("<tr><td>Password: </td><td><input type='password' name='password'></td></tr>");
            out.write("<tr><td></td><td><input type='button' name='enviar' value='Enviar'/></td></table>");
            out.write("</div>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.SKIP_BODY;
    } 
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }
}
