package com.react.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private String studentRollNo;
    private String studentName;
    private String studentClass;

    @DynamoDbAttribute(value = "student_roll_no")
    @DynamoDbPartitionKey
    public String getStudentRollNo() {
        return studentRollNo;
    }

    @DynamoDbAttribute(value = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
