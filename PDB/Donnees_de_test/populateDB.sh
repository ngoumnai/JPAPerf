#!/bin/bash

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"professorNamePath":"/media/441602B11602A450/Ecole/PDB/projet/List_of_professor.txt"}' http://localhost:8080/jpaperf/webresources/populateDataBase/professor  

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"studentNamePath":"/media/441602B11602A450/Ecole/PDB/projets/List_of_student.txt"}' http://localhost:8080/jpaperf/webresources/populateDataBase/student

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"courseNamePath":"/media/441602B11602A450/Ecole/PDB/projets/List_of_course.txt"}' http://localhost:8080/jpaperf/webresources/populateDataBase/course

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"nbrMaxCoursPerProfessor":"3"}' http://localhost:8080/jpaperf/webresources/populateDataBase/courseToProfessor

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"nbrMaxCoursPerStudent":"3"}' http://localhost:8080/jpaperf/webresources/populateDataBase/courseToStudent

curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d ' {"nbrEvent":"200"}' http://localhost:8080/jpaperf/webresources/populateDataBase/event

exit 0
