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
public class Potencia extends TagSupport {
    
    private int base;
    private int exponente;
    
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        int resultado = 1;
        try {
            if (exponente == 0) {
                resultado = 1;
            }
            else {
                for (int i=1; i<=exponente; i++) {
                    resultado = resultado * base;
                }
            }
            //out.write(resultado); No funciona si no se incluye una cadena delante. Desconozco el motivo.
            out.write("" + resultado);
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
