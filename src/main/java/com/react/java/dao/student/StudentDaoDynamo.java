package com.react.java.dao.student;

import com.react.java.model.Student;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

public class StudentDaoDynamo implements StudentDao {

    static final String TABLE_NAME = "Student";
    private final DynamoDbTable<Student> table;

    public StudentDaoDynamo(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.table = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Student.class));
    }

    @Override
    public Optional<Student> getStudent(String rollNo) {
        return Optional.ofNullable(table.getItem(Key.builder().partitionValue(rollNo).build()));
    }

    @Override
    public void saveStudent(Student student) {
        table.putItem(student);
    }
}
