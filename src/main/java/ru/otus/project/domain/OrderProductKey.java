package ru.otus.project.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    long orderId;

    @Column(name = "product_id")
    long productId;
}
