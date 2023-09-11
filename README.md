# Currenda Test assignment
## Natalia Kazmierczak
 *Version date: 2023.09.10* \
 *Generated data: /resources/static/*
## Usage
### \*** GET CASES LIST \***
*http://localhost:8080/case/list*
### \*** GET PARTIES LIST \***
*http://localhost:8080/party/list*
### \*** GET CASES NUMBER FOR EACH STATE FOR TIME WINDOW AND CASE TYPE \***
#### ALL PARAMETERS SPECIFIED:
*http://localhost:8080/case/getBetweenAndType?start=2020-01-01&end=2023-09-09&type=W*
#### TIME PARAMETERS:
*http://localhost:8080/case/getBetweenAndType?start=2020-01-01&end=2023-09-09* \
*http://localhost:8080/case/getBetweenAndType?start=2020-01-01* \
*http://localhost:8080/case/getBetweenAndType?end=2023-09-09* 
#### TYPE PARAMETER:
*http://localhost:8080/case/getBetweenAndType?type=W*
#### DEFAULT VALUES AND ALL TYPES:
*http://localhost:8080/case/getBetweenAndType*
### \*** GET ADDRESSES OF ACTIVE PAGES FOR CASE STATE \***
#### CASE STATE SPECIFIED:
*http://localhost:8080/address/getActiveForState?state=DISMISSED*
#### ALL CASE STATES:
*http://localhost:8080/address/getActiveForState*
### H2 DATABASE CONSOLE:
*http://localhost:8080/h2-console*