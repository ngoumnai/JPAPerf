/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gauss
 */
@Entity
public class JPAQueryExecution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String query;
    private String sqlQuery;        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }   
           
    @Override
    public String toString() {
        return "ch.heigvd.jpaperf.metric.model.JPAQueryExecution[ id=" + id + " ]";
    }
    
}
