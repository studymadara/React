#!/bin/bash

aws dynamodb --endpoint-url=http://localhost:4566 --region=eu-west-1 create-table --table-name Student --attribute-definitions AttributeName=student_roll_no,AttributeType=S --key-schema AttributeName=student_roll_no,KeyType=HASH --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5
aws dynamodb --endpoint-url=http://localhost:4566 --region=eu-west-1 create-table --table-name User --attribute-definitions AttributeName=user_name,AttributeType=S --key-schema AttributeName=user_name,KeyType=HASH --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5

aws dynamodb --endpoint-url=http://localhost:4566 --region=eu-west-1 put-item --table-name User  --item '{"user_name":{"S":"vira"},"user_pass":{"S":"vira"},"user_role":{"S":"ADMIN"}}'
aws dynamodb --endpoint-url=http://localhost:4566 --region=eu-west-1 put-item --table-name Student  --item '{"student_roll_no":{"S":"12"},"student_name":{"S":"vira"},"student_class":{"S":"10th"}}'