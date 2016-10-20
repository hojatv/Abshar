package com.abshar.educational.system.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * JPA-annotation category bean.
 */

@Entity
@Table(name = "course")
public class CourseEntity {
    /** Id. */
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private Integer id;

    /** CourseEntity name. */
    @Column(unique = true, nullable = false)
    private String name;

    /** Educational_Contents for this course. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<EducationalContentEntity> educationalContents;


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param pId the id to set
     */
    public void setId(final Integer pId) {
        id = pId;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param pName the name to set
     */
    public void setName(final String pName) {
        name = pName;
    }

    /**
     * @return the educationalContents
     */
    public Collection<EducationalContentEntity> getEducationalContents() {
        return educationalContents;
    }

    /**
     * @param pEducationalContents the educationalContents to set
     */
    public void setRules(final Collection<EducationalContentEntity> pEducationalContents) { educationalContents= pEducationalContents;   }

}
