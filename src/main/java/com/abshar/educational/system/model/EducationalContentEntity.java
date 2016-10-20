package com.abshar.educational.system.model;

import javax.persistence.*;

/**
 * JPA-annotation category bean.
 */
@Entity
@Table(name = "educational_content")
public class EducationalContentEntity {
    /** Id. */
    @Id
    @GeneratedValue
    @Column(name = "educational_content_id")
    private Integer id;

    /** Course to which this content belongs. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private CourseEntity course;

    /** Teacher to which this content belongs. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private TeacherEntity teacher;

    /** Student to which this content belongs. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentEntity student;

    /** BaseInfo to which this content belongs. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "base_info_id", referencedColumnName = "base_info_id")
    private BaseInfoEntity base_info;

}
