/*
 * @(#)AlignToolBar.java  1.2  2008-05-23
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import javax.swing.border.*;
import org.jhotdraw.util.*;

import java.awt.*;
import javax.swing.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.plaf.palette.*;

/**
 * AlignToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.2 2008-05-23 Hide the toolbar if nothing is selected, and no
 * creation tool is active. 
 * <br>1.1 2008-03-26 Don't draw button borders. 
 * <br>1.0 May 1, 2007 Created.
 */
public final class AlignToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;

    /** Creates new instance. */
    public AlignToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
            displayer.setMinSelectionCount(2);
            displayer.setVisibleIfCreationTool(false);
        }
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.ALIGN_PALETTE)
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        if (state == 1) {
            p = new JPanel();
            configurePanel(p);
            GridBagConstraints gbc = new GridBagConstraints();
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

            configureNorth(p, gbc, labels);
            configureSouth(p, gbc, labels);
            configureEast(p, gbc, labels);
            configureWest(p, gbc, labels);
            configureHorizontal(p, gbc, labels);
            configureVertical(p, gbc, labels); 
        }
        
        return p;
    }
    
    private void configureNorth(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 0, 1, new Insets(3, 0, 0, 0));
        configureButton(p, new AlignAction.North(editor, labels), gbc, Boolean.TRUE);
    }
    
    private void configureSouth(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 1, 1, new Insets(3, 3, 0, 0));
        configureButton(p, new AlignAction.South(editor, labels), gbc, Boolean.TRUE);
    }
    
    private void configureEast(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 1, 0, new Insets(0, 3, 0, 0));
        configureButton(p, new AlignAction.East(editor, labels), gbc, Boolean.TRUE);
    }
    
    private void configureWest(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 0, 0, new Insets(0, 0, 0, 0));
        configureButton(p, new AlignAction.West(editor, labels), gbc, Boolean.FALSE);
    }
    
    private void configureHorizontal(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 0, 2, new Insets(3, 0, 0, 0));
        configureButton(p, new AlignAction.Horizontal(editor, labels), gbc, Boolean.TRUE);
    }
    
    private void configureVertical(JPanel p, GridBagConstraints gbc, ResourceBundleUtil labels) {
        configureGBC(gbc, 1, 2, new Insets(3, 3, 0, 0));
        configureButton(p, new AlignAction.Vertical(editor, labels), gbc, Boolean.TRUE);
    }
    
    private void configurePanel(JPanel panel) {
        GridBagLayout layout = new GridBagLayout();
        
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(5, 5, 5, 8));
        panel.setLayout(layout);
    }
    
    private void configureButton(JPanel panel, AlignAction action, GridBagConstraints gbc, Boolean hideActionText) {
        AbstractButton button = new JButton(action);
        button.setUI((PaletteButtonUI) PaletteButtonUI.createUI(button));
        button.putClientProperty("hideActionText", hideActionText);
        button.setText(null);
        panel.add(button, gbc);
    }
    
    private void configureGBC(GridBagConstraints gbc, int gridx, int gridy, Insets insets) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = insets;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected String getID() {
        return "align";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
