/*
 * #%L
 * elimu-service
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2012 Coders4Africa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package org.coders4africa.elimu.service.school;

import java.util.List;
import org.coders4africa.elimu.domain.school.Employee;
import org.coders4africa.elimu.domain.school.School;
import org.coders4africa.elimu.domain.school.Student;
import org.coders4africa.elimu.service.exception.EntityNotFoundException;
import org.coders4africa.elimu.service.exception.NotFoundException;

/**
 * Elimu system's schools management contract
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
public interface SchoolService {

    //~ Methods related to schools themselve
    
    /**
     * Return the number of schools registered into Elimu system
     * 
     * @return The number of schools registered into Elimu system
     */
    String countSchools();

    /**
     * Register a new shool into Elimu system
     * 
     * @param school The new shool to register into the system
     */
    void registerSchool(School school);

    /**
     * Updates informations for a school already registered into Elimu system
     * 
     * @param school The school for which informations have to be updated 
     */
    void updateSchoolInformation(School school);

    /**
     * Search a school into Elimu system given an identifier
     * 
     * @param id The identifier of the registered school to look for
     * @return The founded school instance or null if the school does not exist
     */
    School findSchool(Long id);

    /**
     * Retrieves all the shools registered into Elimu system
     * @return All the shools instances registered into Elimu system
     */
    List<School> retrieveAllSchools();

    /**
     * Unregisters the school with the given identifier from Elimu system.<br/>
     * That drops the shool instance from Elimu system. <br/> 
     * <b>All the Employees of the school are also droped from the system.</b>
     * 
     * @param id  The identifier of the school to unregister
     */
    void unregisterSchool(Long id);
     
    
    
    
    //~ Methods related to schools employees
    
    /**
     * Register a new Employee from a given school into Elimu system.
     * 
     * @param employee The employee to register
     * @param schoolId The identifier of the shool for which the employee works.
     * 
     * @throws NotFoundException Raised if the school doesn't exists into Elimu system. 
     */
    void registerEmployee(Employee employee, Long schoolId) throws NotFoundException;
    
    /**
     * Unregisters a employee from a given school.<br/>
     * That drops the employee instance from Elimu system.
     * 
     * @param employeeId The identifier of the employee to employee to unregister
     * @throws NotFoundException Raised if the the employee doesn't exist or is not attached to the given school.
     * @throws EntityNotFoundException Raised if the school referenced by the employee instance doesn't exists.
     */
    void unregisterEmployee(Long schoolId,Long employeeId) throws NotFoundException, EntityNotFoundException;
    
    /**
     * Retrives all employees of a given school.
     * 
     * @param schoolId The identifier of the school for which employees have to be searched.
     * @return All employees of the given school.
     */
    List<Employee> retrieveAllEmployees(Long schoolId);
    
    /**
     * Return the number of employees of a given school.
     * 
     * @param schoolId The identifier of the school for which employees have to be counted.
     * @return The number of employees of the given school.
     */
    String countEmployees(Long schoolId);
    
    
    
    //~ Methods related to schools students
    
    /**
     * Register a new Student from a given school into Elimu system.
     * 
     * FIXME The classroomId have to be calculated upon available
     * classrooms for the stident grade, not to be passed as param
     * 
     * @param student The student to register
     * @param schoolId The identifier of the shool for which the employee works.
     * @param classroomId The identifier of the school's classroom in which the student has to be register.
     * 
     * @throws NotFoundException Raised if the school doesn't exists into Elimu system or the classroom is not attached to the given school. 
     */
    void registerStudent(Student student, Long schoolId, Long classroomId) throws NotFoundException;
    
    /**
     * Unregisters a student from a given school.<br/>
     * That drops the student instance from Elimu system.
     * 
     * @param schoolId The identifier of the school of the student to unregister
     * @param studentId The identifier of the student to employee to unregister
     * @throws NotFoundException Raised if the the student doesn't exist or is not attached to the given school.
     * @throws EntityNotFoundException Raised if the school referenced by the student instance doesn't exists.
     */
    void unregisterStudent(Long schoolId,Long studentId) throws NotFoundException, EntityNotFoundException;
    
    /**
     * Retrives all students of a given school.
     * 
     * @param schoolId The identifier of the school for which students have to be search.
     * @return All students of the given school.
     */
    List<Student> retrieveAllStudents(Long schoolId);
    
    /**
     * Retrives all students of a given classroom and a given shool.
     * 
     * @param schoolId The identifier of the school for which student have to be search.
     * @param classroomId The identifier of the classroom of the students
     * @return All students of the given school ans classroom.
     */
    List<Student> retrieveAllStudents(Long schoolId, Long classroomId);
    
    /**
     * Return the number of students of a given school.
     * 
     * @param schoolId The identifier of the school for which students have to be count.
     * @return The number of students of the given school.
     */
    String countStudents(Long schoolId);
    
    /**
     * Return the number of students of a given school and classroom.
     * 
     * @param schoolId The identifier of the school for which students have to be count.
     * @param classroomId The identifier of the classroom of the students
     * @return The number of students of the given school ans classroom.
     */
    String countStudents(Long schoolId, Long classroomId);
}
