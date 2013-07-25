/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.model.Bean;

import ch.heigvd.perfviewer.model.query.JpaQueryExecution;
import java.io.Serializable;

/**
 *
 * @author gauss
 */
public class JPQLRequestDetailsBean implements Serializable {    
    private String executiondate;
    private String query;
    private String sqlquery;
    
    public JPQLRequestDetailsBean(){}
    
    public JPQLRequestDetailsBean(JpaQueryExecution jQExecution){
        query = jQExecution.getQuery();
        sqlquery = jQExecution.getSqlquery();
    }

    public String getExecutiondate() {
        return executiondate;
    }

    public void setExecutiondate(String executiondate) {
        this.executiondate = executiondate;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSqlquery() {
        return sqlquery;
    }

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }       
}
