package com.abshar.educational.system.persistence;

import com.abshar.educational.system.model.StudentEntity;

/**
 * Created by hovaheb on 10/19/2016.
 */
public interface DataDao {
    StudentEntity findStudentById(Integer id);
}
