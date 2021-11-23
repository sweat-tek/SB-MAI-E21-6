package org.jhotdraw.draw.action;


import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class LayoutContainerData {
    Container parent;
    Insets insets;
    int w;
    int h;
    boolean ltr;
    int nrows;
    int ncols;
    int ncomponents;

    public Container getParent() {
        return parent;
    }

    public Insets getInsets() {
        return insets;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public boolean isLtr() {
        return ltr;
    }

    public int getNrows() {
        return nrows;
    }

    public int getNcols() {
        return ncols;
    }

    public int getNcomponents() {
        return ncomponents;
    }
    
    
    
    public LayoutContainerData(
            Container parent,
            Insets insets,
            int w,
            int h,
            boolean ltr,
            int nrows,
            int ncols,
            int ncomponents
    ){
        this.parent = parent;
        this.insets = insets;
        this.w = w;
        this.h = h;
        this.ltr = ltr;
        this.ncols = ncols;
        this.nrows = nrows;
        this.ncomponents = ncomponents;
    }

}
