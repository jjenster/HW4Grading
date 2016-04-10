#!/bin/sh

for student in "submissions_all/"*
do
    cp grader/src/GradeKBest.java "$student/GradeKBest.java"
    cp grader/src/KBestCounterGold.java "$student/KBestCounterGold.java"
    cp grader/src/grade.sh "$student/grade.sh"
    cd "/Users/linanqiu/Desktop/cs3134/HW4Grading/$student"
    sh grade.sh
    cd "/Users/linanqiu/Desktop/cs3134/HW4Grading/"
done
