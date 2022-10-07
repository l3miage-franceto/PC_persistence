package edu.uga.miage.m1.polygons.gui.strategy;

import edu.uga.miage.m1.polygons.gui.shapes.SimpleShape;

import java.io.File;
import java.util.List;

public class ImportFile {

    private final File file;

    public ImportFile(File file){
        this.file = file;
    }

    public List<SimpleShape> createShapesList(ImportStrategy strategy){
        return strategy.importShapes(file);
    }

}