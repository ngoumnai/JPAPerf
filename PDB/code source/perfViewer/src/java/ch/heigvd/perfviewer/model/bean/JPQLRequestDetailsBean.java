/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package ch.heigvd.perfviewer.model.bean;

import ch.heigvd.perfviewer.model.query.JPAQuery;
import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author gauss
*/
public class JPQLRequestDetailsBean implements Serializable {
    private long executionTime;
    private String executionDate;
    private String queryName;
    private ArrayList<String> sqlQueries;
    
    public JPQLRequestDetailsBean(){}
    
    public JPQLRequestDetailsBean(JPAQuery jpaQuery){
        this.queryName = jpaQuery.getQueryname();
        this.executionDate = jpaQuery.getExecutiondate();
        this.executionTime = jpaQuery.getExecutiontime();
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public ArrayList<String> getSqlQueries() {
        return sqlQueries;
    }

    public void setSqlQuerries(ArrayList<String> sqlQuerries) {
        this.sqlQueries = sqlQuerries;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
    
}
