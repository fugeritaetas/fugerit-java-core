package org.fugerit.java.core.xml.simple;

import java.util.Properties;

import org.fugerit.java.core.xml.XMLException;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public interface XMLGenerator {

    public void addText(String text);
    
    public void openTag(String name);
    
    public void openTag(String name, Properties att);
    
    public void closeTag(String name);
    
    public void addTag(String name, String text);
    
    public void addTag(String name, Properties att);
    
    public void addTag(String name, Properties att, String text);

    public void emptyTag(String name);
    
    public void emptyTag(String name, Properties att);
    
    public void close() throws XMLException;
    
}
