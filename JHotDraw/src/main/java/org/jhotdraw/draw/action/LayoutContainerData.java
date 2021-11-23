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
