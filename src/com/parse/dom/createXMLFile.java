package com.parse.dom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class createXMLFile {
    final SAXBuilder saxBuilder = new SAXBuilder();
    final File bookFile = new File("Libro2.xml");
    final Document document = saxBuilder.build(bookFile);
    Element root = document.getRootElement();

    public createXMLFile() throws IOException, JDOMException {
    }

    public void JDOM() throws JDOMException, IOException {
        System.out.println(root.getName());
        List<Element> libros = root.getChildren("Libro");
        for (Element libro : libros) {
            String name = libro.getAttributeValue("titulo");
            String title = libro.getTextNormalize();
            System.out.println("\t" + name + " : " + title);
            List<Element> autores = libro.getChildren("autor");
            for (Element autor : autores) {
                String nameA = autor.getAttributeValue("autor");
                String nombre = autor.getTextNormalize();
                System.out.println("\t\t" + nameA + " : " + nombre);
            }
            List<Element> secciones = libro.getChildren("seccion");
            for (Element seccion : secciones) {
                String seccName = seccion.getAttributeValue("titulo");
                String seccText = seccion.getTextNormalize();
                System.out.println("\t\t" + seccName + " : " + seccText);

                List<Element> capitulos = seccion.getChildren("capitulo");
                for (Element capitulo : capitulos) {
                    String capName = capitulo.getAttributeValue("titulo");
                    String capText = capitulo.getTextNormalize();
                    System.out.println("\t\t\t" + capName + " : " + capText);

                    List<Element> parrafos = capitulo.getChildren("parrafo");
                    for (Element parrafo : parrafos) {
                        String parName = parrafo.getAttributeValue("titulo");
                        String parTetx = parrafo.getTextNormalize();
                        System.out.println("\t\t\t\t" + parName + " : " + parTetx);

                    }
                }
            }

        }
    }

    public void addSeccion(String libroName, String nameTitle, String texto) {
        List<Element> libros = root.getChildren("Libro");
        for (Element libro : libros) {
            if (libro.getAttributeValue("titulo").equals(libroName)) {
                Element seccion = new Element("seccion");
                seccion.setAttribute("titulo", nameTitle);
                seccion.setText(texto);
                libro.addContent(seccion);
            }
        }
    }

    public void addCapitulo(String libroName, String Seccion, String capituloName, String texto){
        List<Element> libros = root.getChildren("Libro");
        for (Element libro : libros) {
            if (libro.getAttributeValue("titulo").equals(libroName)){
                List<Element> secciones = libro.getChildren("seccion");
                for (Element seccion : secciones){
                    if (seccion.getAttributeValue("titulo").equals(Seccion)){
                        Element cap = new Element("capitulo");
                        cap.setAttribute("titulo",capituloName);
                        cap.setText(texto);
                        seccion.addContent(cap);
                    }
                }
            }
        }
    }

    public void addParrafo(String libroName, String Seccion, String capituloName, String parrafoName, String texto){
        List<Element> libros = root.getChildren("Libro");
        for (Element libro : libros) {
            if (libro.getAttributeValue("titulo").equals(libroName)){
                List<Element> secciones = libro.getChildren("seccion");
                for (Element seccion : secciones){
                    if (seccion.getAttributeValue("titulo").equals(Seccion)){
                        List<Element> Capitulos = seccion.getChildren("capitulo");
                        for (Element capitulo : Capitulos){
                            if (capitulo.getAttributeValue("titulo").equals(capituloName)){
                                Element par = new Element("parrafo");
                                par.setAttribute("titulo", parrafoName);
                                par.setText(texto);
                                capitulo.addContent(par);
                            }
                        }
                    }
                }
            }
        }
    }

}
