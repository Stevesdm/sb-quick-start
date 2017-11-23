package com.steve.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by SteveJobson on 2017/8/2.
 */
//    public static void main(String[] args) {
//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Student s = new Student();
//        s.setName("999999");
//        s.setAge(101);
//        Set<ConstraintViolation<Student>> validators = validator.validate(s);
//        for (ConstraintViolation<Student> constraintViolation : validators) {
//            System.out.println(constraintViolation.getMessage());
//        }
//
//    }

public class Student{

    @NotNull(message = "id不能为空")
    private String id;

    @Length(min=2,max=4,message = "name在2-4位之间")
    private String name;

    @Max(value = 100, message = "年龄最大为100")
    @Min(value= 10, message = "年龄最小为10")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}