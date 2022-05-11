package com.parse.dom;

import org.jdom.JDOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JDOMException {
        Libros lib = new Libros("Mi Libro");
        lib.addLibro("Libro 1");
        lib.addLibro("Libro 2");
        lib.addAutor("autor 1", "Libro 1");
        lib.addAutor("autor 2", "Libro 1");
        lib.addAutor("autor 3", "Libro 2");
        lib.agregarSeccion("Seccion 1", "Libro 1");
        lib.agregarSeccion("Seccion 2", "Libro 2");
        lib.agregarCapitulo("Capitulo 1", "Seccion 1");
        lib.agregarParrafo("Primer parrafo","Capitulo 1");
        lib.agregarCapitulo("Capitulo 2", "Seccion 1");
        lib.vizualizarLibro();

        createXMLFile createXMLFile = new createXMLFile();

        createXMLFile.JDOM();
        System.out.println("\n\nAñadiendo elementos con JDOM\n\n");

        createXMLFile.addSeccion("Libro 2", "Seccion 2", "Esta es la seccion 2");
        createXMLFile.addCapitulo("Libro 2", "Seccion 2", "Capitulo 1", "Un pequeño..." );
        createXMLFile.addParrafo("Libro 1", "Seccion 1", "Capitulo 1", "parrafo 3", "Nuevo parrafo");
        createXMLFile.addParrafo("Libro 2", "Seccion 2", "Capitulo 1", "parrafo 1", "hola");


        createXMLFile.JDOM();

    }
}
