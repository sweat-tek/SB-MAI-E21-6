/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;
import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.beans.*;
import java.util.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;

/**
 *
 * @author joakimbetzer
 */
public class ReverseAction extends AbstractViewAction{

    public String ID;
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
    
    //Constructor
    public ReverseAction (Application app){
        super(app);
    }
    
    //PropertyChangeListener
    private PropertyChangeListener reverseActionPropertyListener = new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name == AbstractAction.NAME) {
                putValue(AbstractAction.NAME, evt.getNewValue());
            } else if (name == "enabled") {
                updateEnabledState();
            }
        }
    };
    
    protected void updateEnabledState() {
        boolean isEnabled = false;
        Action reverseAction = getRealReverseAction();
        if (reverseAction != null) {
            isEnabled = reverseAction.isEnabled();
        }
        setEnabled(isEnabled);
    }
    
    @Override protected void updateView(View oldValue, View newValue) {
        super.updateView(oldValue, newValue);
        if (newValue != null && newValue.getAction(ID) !=  null) {
            putValue(AbstractAction.NAME, newValue.getAction(ID).
                    getValue(AbstractAction.NAME));
            updateEnabledState();
        }
    }
    
    /**
     * Installs listeners on the view object.
     */
    @Override protected void installViewListeners(View p) {
        super.installViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).addPropertyChangeListener(reverseActionPropertyListener);
        }
    }
    
    /**
     * Installs listeners on the view object.
     */
    @Override protected void uninstallViewListeners(View p) {
        super.uninstallViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).removePropertyChangeListener(reverseActionPropertyListener);
        }
    }
    
    @FeatureEntryPoint(JHotDrawFeatures.UNDO_REDO)
    public void actionPerformed(ActionEvent e) {
        Action reverseAction = getRealReverseAction();
        if (reverseAction != null) {
            reverseAction.actionPerformed(e);
        }
    }
    
    private Action getRealReverseAction() {
        return (getActiveView() == null) ? null : getActiveView().getAction(ID);
    }
    
}
