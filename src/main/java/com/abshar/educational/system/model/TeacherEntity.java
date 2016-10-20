package com.abshar.educational.system.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * JPA-annotation category bean.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    /** Id. */
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Integer id;

    /** StudentEntity first_name. */
    @Column(nullable = false)
    private String first_name;

    /** StudentEntity last_name. */
    @Column( nullable = false)
    private String last_name;

    /** Educational_Contents for this student. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<EducationalContentEntity> educationalContents;

    /** StudentEntity contact. */
    @Column(unique = true, nullable = false)
    private String contact;

}
