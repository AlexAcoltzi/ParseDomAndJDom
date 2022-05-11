package com.parse.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Libros {
    private Transformer transformer;
    TransformerFactory transformerFactory;
    private Document document;

    public Libros(String name)
    {
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element raiz = document.createElement("biblio");
            document.appendChild(raiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLibro(String name){
        Element libro = document.createElement("Libro");
        libro.setAttribute("titulo", name);
        libro.setIdAttribute("titulo", true);
        document.getDocumentElement().appendChild(libro);
    }

    public void addAutor(String name, String libros){
        Element libro = document.getElementById(libros);
        if (libro != null){
            Element autor = document.createElement("autor");
            autor.setAttribute("autor", name);
            autor.setIdAttribute("autor", true);
            autor.appendChild(document.createTextNode(name));
            libro.appendChild(autor);
        }
    }

    public void agregarParrafo(String texto, String tituloCapitulo)
    {
        Element cap = document.getElementById(tituloCapitulo);
        if (cap != null)
        {
            Element parrafo = document.createElement("parrafo");
            parrafo.appendChild(document.createTextNode(texto));
            cap.appendChild(parrafo);
        }
    }
    public  void agregarCapitulo(String titulo, String seccion)
    {
        Element sec = document.getElementById(seccion);
        if (sec != null)
        {
            Element capitulo = document.createElement("capitulo");
            capitulo.appendChild(document.createTextNode(titulo));
            capitulo.setAttribute("titulo", titulo);
            capitulo.setIdAttribute("titulo", true);
            sec.appendChild(capitulo);
        }
    }
    public void agregarSeccion(String tituloSeccion, String libro)
    {
        Element lib = document.getElementById(libro);
        if (lib != null) {
            Element seccion = document.createElement("seccion");
            seccion.setAttribute("titulo", tituloSeccion);
            seccion.setIdAttribute("titulo", true);
            lib.appendChild(seccion);
        }
    }
    public void vizualizarLibro() {
        try {
            DOMSource domSource = new DOMSource(document);
            StreamResult result = new StreamResult(new File("Libro.xml"));
            transformer.transform(domSource, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
