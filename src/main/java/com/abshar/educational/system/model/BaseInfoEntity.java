package com.abshar.educational.system.model;

/**
 * JPA-annotation category bean.
 */
import javax.persistence.*;

@Entity
@Table(name = "base_info")
public class BaseInfoEntity {
    /** Id. */
    @Id
    @GeneratedValue
    @Column(name="base_info_id")
    private Integer id;



}
