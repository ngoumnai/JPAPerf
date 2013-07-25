/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gauss
 */
public class MetricBean implements Serializable {
    
    private String QueryName;
    private String entity;
    private String sql;
    private long avgTime;
    private long minTime;
    private long maxTime;
    private long sumTime;
    private long nbrOfQueries;
    List<Jpaquery> queryList;
    
    public MetricBean(){
        queryList = new ArrayList<Jpaquery>();
    }

    public String getQueryName() {
        return QueryName;
    }

    public void setQueryName(String QueryName) {
        this.QueryName = QueryName;
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
    public void addMetricEvent(Jpaquery jpaQuery){
        long time = jpaQuery.getExecutiontime();
        queryList.add(jpaQuery);
        nbrOfQueries+=1;
        sumTime +=time;
        avgTime = sumTime/nbrOfQueries;        
        
        if(time > maxTime){
            maxTime = jpaQuery.getExecutiontime();
        }
        else if(time < minTime){
            minTime = jpaQuery.getExecutiontime();
        }
        
                
    }
}
