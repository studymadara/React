package com.react.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {

    private String id;
    private String studentName;
    private String studentRollNo;
    private String studentClass;

    @DynamoDbAttribute(value = "id")
    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    @DynamoDbAttribute(value = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @DynamoDbAttribute(value = "student_roll_no")
    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    @DynamoDbAttribute(value = "student_class")
    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
