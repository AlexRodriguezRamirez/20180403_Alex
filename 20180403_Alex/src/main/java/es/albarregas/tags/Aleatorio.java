/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tags;

import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Alex
 */
public class Aleatorio extends TagSupport {
    private int minimo;
    private int maximo;

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        
        int numero;
        Random aleatorio = new Random();
        
        try {
            numero = minimo + aleatorio.nextInt(maximo);
            //out.write(numero); no funciona, al igual que en la clase Repetir.
            out.write("" + numero);
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
