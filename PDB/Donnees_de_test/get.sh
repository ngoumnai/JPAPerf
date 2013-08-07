#!/bin/bash

while read line  
do   
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET  http://localhost:8080/jpaperf/webresources/professor/name/${line}
done < /media/441602B11602A450/Ecole/PDB/projet/List_of_professor.txt


while read line  
do   
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET  http://localhost:8080/jpaperf/webresources/student/name/${line}
done < /media/441602B11602A450/Ecole/PDB/projet/List_of_student.txt

for i in {1..50} ; do
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET  http://localhost:8080/jpaperf/webresources/student/period/${i}
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET  http://localhost:8080/jpaperf/webresources/professor/period/${i}
done

for i in {1..16} ; do
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET  http://localhost:8080/jpaperf/webresources/course/period/${i}
done

exit 0
