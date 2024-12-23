// Management.java
package less1.Person.Tree;

import java.io.Serializable;
import java.util.List;

public interface ManagementTree<T extends ManagementTree<T>> extends Serializable {
    String getName();
    int getYearOfBirth();
    String getFace_type();

    T getFather();
    T getMother();
    T getSpouse();
    List<T> getChildren();
    List<T> getSiblings();

    void setFather(T father);
    void setMother(T mother);
    void setSpouse(T spouse);
    void addChild(T child);
    void addSiblings(T sibling);
}


