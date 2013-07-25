/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.model.query;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gauss
 */
@Entity
@Table(name = "JPAQUERY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jpaquery.findByQueryname", query = "SELECT j FROM Jpaquery j WHERE j.queryname = :queryname")})
public class JPAQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "ENTITYQUERIED")
    private String entityqueried;
    @Size(max = 255)
    @Column(name = "EXECUTIONDATE")
    private String executiondate;
    @Column(name = "EXECUTIONTIME")
    private long executiontime;
    @Size(max = 255)
    @Column(name = "JPQL")
    private String jpql;
    @Size(max = 255)
    @Column(name = "QUERYNAME")
    private String queryname;
    @Size(max = 255)
    @Column(name = "SQLQUERY")
    private String sqlquery;
    @JoinTable(name = "JPAQUERY_JPAQUERYEXECUTION", joinColumns = {
        @JoinColumn(name = "JPAQuery_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "jpaQueryExecution_ID", referencedColumnName = "ID")})
    @OneToMany
    private Collection<JpaQueryExecution> jpaqueryexecutionCollection;

    public JPAQuery() {
    }

    public JPAQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityqueried() {
        return entityqueried;
    }

    public void setEntityqueried(String entityqueried) {
        this.entityqueried = entityqueried;
    }

    public String getExecutiondate() {
        return executiondate;
    }

    public void setExecutiondate(String executiondate) {
        this.executiondate = executiondate;
    }

    public long getExecutiontime() {
        return executiontime;
    }

    public void setExecutiontime(long executiontime) {
        this.executiontime = executiontime;
    }

    public String getJpql() {
        return jpql;
    }

    public void setJpql(String jpql) {
        this.jpql = jpql;
    }

    public String getQueryname() {
        return queryname;
    }

    public void setQueryname(String queryname) {
        this.queryname = queryname;
    }

    public String getSqlquery() {
        return sqlquery;
    }

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    @XmlTransient
    public Collection<JpaQueryExecution> getJpaqueryexecutionCollection() {
        return jpaqueryexecutionCollection;
    }

    public void setJpaqueryexecutionCollection(Collection<JpaQueryExecution> jpaqueryexecutionCollection) {
        this.jpaqueryexecutionCollection = jpaqueryexecutionCollection;
    }
    
    @Override
    public String toString() {
        return "ch.heigvd.perfviewer.model.Jpaquery[ id=" + id + " ]";
    }
    
}
