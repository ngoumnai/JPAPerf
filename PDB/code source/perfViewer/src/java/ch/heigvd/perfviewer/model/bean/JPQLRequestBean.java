/*
* Permet de definir les informations qui seront afficher par la vue.
*/
package ch.heigvd.perfviewer.model.bean;

import ch.heigvd.perfviewer.model.query.JPAQuery;
import java.io.Serializable;

/**
*
* @author gauss
*/
public class JPQLRequestBean implements Serializable {
    
    private String queryName;
    private String entity;
    private String jpql;
    private String sql;
    private long avgTime;
    private long minTime;
    private long maxTime;
    private long sumTime;
    private long nbrOfQueries;
    
    public JPQLRequestBean(){}
    
    public JPQLRequestBean(JPAQuery jpaQuery){
        queryName = jpaQuery.getQueryname();
        entity = jpaQuery.getEntityqueried();
        sql = jpaQuery.getSqlquery();
        jpql = jpaQuery.getJpql();
        nbrOfQueries = 1;
        avgTime = jpaQuery.getExecutiontime();
        minTime = jpaQuery.getExecutiontime();
        maxTime = jpaQuery.getExecutiontime();
        sumTime = jpaQuery.getExecutiontime();
    }
               
    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String QueryName) {
        this.queryName = QueryName;
    }

    public String getJpql() {
        return jpql;
    }

    public void setJpql(String jpql) {
        this.jpql = jpql;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(long avgTime) {
        this.avgTime = avgTime;
    }

    public long getMinTime() {
        return minTime;
    }

    public void setMinTime(long minTime) {
        this.minTime = minTime;
    }

    public long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(long maxTime) {
        this.maxTime = maxTime;
    }

    public long getSumTime() {
        return sumTime;
    }

    public void setSumTime(long sumTime) {
        this.sumTime = sumTime;
    }

    public long getNbrOfQueries() {
        return nbrOfQueries;
    }

    public void setNbrOfQueries(long nbrOfQueries) {
        this.nbrOfQueries = nbrOfQueries;
    }
    
    /**
* Ajoute un object MetricEvent à une liste et met à jour les timers
* @param jpaQuery
*/
    public void setJPQLRequestInfo(JPAQuery jpaQuery){
        long time = jpaQuery.getExecutiontime();
        nbrOfQueries+=1;
        sumTime +=time;
        avgTime = sumTime/nbrOfQueries;
        
        if(time > maxTime){
            maxTime = time;
        }
        else if(time < minTime){
            minTime = time;
        }
    }
}
