package Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneClass implements Serializable, Cloneable {
    /*
     * 父类静态成员变量、静态代码块（如果有）
     * 子类静态成员变量、静态代码块（如果有）
     * 父类构造方法（实例化对象时）
     * 子类构造方法（实例化对象时）
     */

    private String field;
    private NestedClass nestedClass;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneClass cloned = (CloneClass) super.clone();
        cloned.nestedClass = (NestedClass) nestedClass.clone();
        return cloned;
    }

    public CloneClass deepCopy() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (CloneClass) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

class NestedClass implements Serializable, Cloneable {
    private int nestedField;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
