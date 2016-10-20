package com.abshar.educational.system.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * JPA-annotation category bean.
 */
@Entity
@Table(name = "student")
public class StudentEntity {
    /** Id. */
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Integer id;

    /** StudentEntity first_name. */
    @Column(nullable = false)
    private String first_name;

    /** StudentEntity last_name. */
    @Column( nullable = false)
    private String last_name;

    /** Educational_Contents for this student. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<EducationalContentEntity> educationalContents;

    /** StudentEntity contact. */
    @Column(unique = true, nullable = false)
    private String contact;

    /**
     * @return the id
     */

    public Integer getId() {
        return id;
    }
    /**
     * @param pId the id to set
     */
    public void setId(Integer pId) {
        this.id = pId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
