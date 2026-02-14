package Interfaces;

import Exceptions.IllegalUsefullnessException;

public interface Usefull {
    int getUsefulness();
    void setUsefulness(int usefullness) throws IllegalUsefullnessException;
}
