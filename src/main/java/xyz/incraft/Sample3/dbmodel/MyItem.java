package xyz.incraft.Sample3.dbmodel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Михаил on 07.01.2016.
 */
@Entity
@Table(name="myitems")
public class MyItem {
    private Integer id;
    private SimpleItem si1;
    private SimpleItem si2;

    public MyItem() {
    }

    public MyItem(SimpleItem si1, SimpleItem si2) {
        this.si1 = si1;
        this.si2 = si2;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Si1ID")
    public SimpleItem getSi1() {
        return si1;
    }

    public void setSi1(SimpleItem si1) {
        this.si1 = si1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Si2ID")
    public SimpleItem getSi2() {
        return si2;
    }

    public void setSi2(SimpleItem si2) {
        this.si2 = si2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyItem myItem = (MyItem) o;

        if (si1 != null ? !si1.equals(myItem.si1) : myItem.si1 != null) return false;
        return si2 != null ? si2.equals(myItem.si2) : myItem.si2 == null;

    }

    @Override
    public int hashCode() {
        int result = si1 != null ? si1.hashCode() : 0;
        result = 31 * result + (si2 != null ? si2.hashCode() : 0);
        return result;
    }
}
