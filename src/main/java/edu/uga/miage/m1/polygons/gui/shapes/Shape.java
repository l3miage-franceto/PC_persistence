package edu.uga.miage.m1.polygons.gui.shapes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;


/**
 * This interface defines the <tt>SimpleShape</tt> extension. This extension
 * is used to draw shapes.
 *
 * @author <a href="mailto:christophe.saint-marcel@univ-grenoble-alpes.fr">Christophe</a>
 */
@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Square.class, name = "square"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = GroupShape.class, name = "groupShape")
})
@JsonIgnoreProperties(value = { "shapeDraw" })
public abstract class Shape implements IsInside {

    private int x;
    private int y;
    @JsonIgnore
    protected java.awt.Shape shapeDraw;

    protected Shape(int x, int y) {
        this.x = x;
        this.y = y;
        setShapeDraw();
    }

    protected Shape(Shape original) {
        if (Objects.nonNull(original)) {
            this.x = original.getX();
            this.y = original.getY();
            this.shapeDraw = original.getShapeDraw();
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public java.awt.Shape getShapeDraw(){
        return shapeDraw;
    }

    public abstract void setShapeDraw();

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
        setShapeDraw();
    }

    @Override
    public boolean isInside(int x, int y) {
        return shapeDraw.contains(x, y);
    }
}