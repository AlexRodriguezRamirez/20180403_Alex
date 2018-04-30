/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tags;


import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
/**
 *
 * @author Alex
 */
public class Repetir extends TagSupport implements DynamicAttributes {
    
    private int numero;
    private String mensaje;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        
        try {
            for (int i=1; i<=numero; i++) {
                out.write(mensaje + "<br>");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.SKIP_BODY;
    } 
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
