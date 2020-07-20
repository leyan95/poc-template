package org.hv.template;

import org.hv.pocket.annotation.Column;
import org.hv.pocket.annotation.Entity;
import org.hv.pocket.model.BaseEntity;

/**
 * @author wujianchuan
 */
@Entity(table = "TBL_ORDER_TYPE")
public class OrderType extends BaseEntity {
    private static final long serialVersionUID = -4481356247007947438L;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
