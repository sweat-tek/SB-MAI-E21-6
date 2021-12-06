package org.jhotdraw.draw;
import java.io.Serializable;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.util.*;

public class AttributeKey<T> implements Serializable {
    private String key;
    private T defaultValue;
    private boolean isNullValueAllowed;
    private ResourceBundleUtil labels;
    private Class<T> clazz;

    public AttributeKey(String key, Class<T> clazz) {
        this(key, clazz, null, true);
    }

    public AttributeKey(String key, Class<T> clazz, T defaultValue) {
        this(key, clazz, defaultValue, true);
    }

    public AttributeKey(String key, Class<T> clazz, T defaultValue, boolean isNullValueAllowed) {
        this.key = key;
        this.clazz = clazz;
        this.defaultValue = defaultValue;
        this.isNullValueAllowed = isNullValueAllowed;
    }

    public AttributeKey(String key, Class<T> clazz, T defaultValue, boolean isNullValueAllowed, ResourceBundleUtil labels) {
        this.key = key;
        this.clazz = clazz;
        this.defaultValue = defaultValue;
        this.isNullValueAllowed = isNullValueAllowed;
        this.labels = labels;
    }

    public String getKey() {
        return key;
    }

    public String getPresentationName() {
        return (labels == null) ? key : labels.getString("attribute." + key + ".text");
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    @SuppressWarnings("unchecked")
    public T getClone(Figure f) {
        T value = get(f);
        try {
            return value == null ? null : clazz.cast(Methods.invoke(value, "clone"));
        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    public T get(Figure f) {
        T value = (T) f.getAttribute(this);
        return (value == null && !isNullValueAllowed) ? defaultValue : value;
    }

    @SuppressWarnings("unchecked")
    public T get(Map<AttributeKey, Object> a) {
        T value = (T) a.get(this);
        return (value == null && !isNullValueAllowed) ? defaultValue : value;
    }

    public void set(Figure f, T value) {
        f.willChange();
        basicSet(f, value);
        f.changed();
    }

    public void basicSet(Figure f, T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }
        f.setAttribute(this, value);
    }

    public UndoableEdit setUndoable(final Figure figure, final T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }

        final Object restoreData = figure.getAttributesRestoreData();
        figure.willChange();
        figure.setAttribute(this, value);
        figure.changed();

        UndoableEdit edit = new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                return AttributeKey.this.getPresentationName();
            }

            @Override
            public void undo() {
                super.undo();
                figure.willChange();
                figure.restoreAttributesTo(restoreData);
                figure.changed();
            }

            @Override
            public void redo() {
                super.redo();
                figure.willChange();
                figure.setAttribute(AttributeKey.this, value);
                figure.changed();
            }
        };
        return edit;

    }

    public void setClone(Figure f, T value) {
        f.willChange();
        basicSetClone(f, value);
        f.changed();
    }

    public void basicSetClone(Figure f, T value) {
        try {
            basicSet(f, value == null ? null : clazz.cast(Methods.invoke(value, "clone")));

        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    public void set(Map<AttributeKey, Object> a, T value) {
        put(a, value);
    }

    @SuppressWarnings("unchecked")
    public T put(Map<AttributeKey, Object> a, T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }
        return (T) a.put(this, value);
    }

    @SuppressWarnings("unchecked")
    public void setClone(Map<AttributeKey, Object> a, T value) {
        try {
            set(a, value == null ? null : (T) Methods.invoke(value, "clone"));
        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    public boolean isNullValueAllowed() {
        return isNullValueAllowed;
    }

    public boolean isAssignable(Object value) {
        if (value == null) {
            return isNullValueAllowed();
        }

        return clazz.isInstance(value);
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
    @Override
    public boolean equals(Object that) {
        if (that instanceof AttributeKey) {
        return ((AttributeKey) that).key.equals(this.key);
        }
        return false;
    }
}
