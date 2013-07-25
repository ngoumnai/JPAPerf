/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author gauss
 */
@Entity
public class JPAQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String entityQueried;
    private String jpql;
    private String queryName;
    private String sqlQuery;
    private String executionDate;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.PERSIST})
    private List<JPAQueryExecution> jpaQueryExecution;
    private long executionTime;
    
    public JPAQuery(){
        jpaQueryExecution = new ArrayList<JPAQueryExecution>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getEntityQueried() {
        return entityQueried;
    }

    public void setEntityQueried(String entityQueried) {
        this.entityQueried = entityQueried;
    }

    public String getJpql() {
        return jpql;
    }

    public void setJpql(String jpql) {
        this.jpql = jpql;
    }

    public List<JPAQueryExecution> getJpaQueryExecution() {
        return jpaQueryExecution;
    }

    public void addJpaQueryExecution(JPAQueryExecution query) {
        this.jpaQueryExecution.add(query);
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
    
    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }
        
    @Override
    public String toString() {
        return "ch.heigvd.jpaperf.metric.model.MetricEvent[ id=" + id + " ]";
    }
    
}
