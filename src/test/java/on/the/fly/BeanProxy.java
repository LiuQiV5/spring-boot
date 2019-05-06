package on.the.fly;

public interface BeanProxy {
    void setDirty(boolean dirty);

    boolean isDirty();
}
