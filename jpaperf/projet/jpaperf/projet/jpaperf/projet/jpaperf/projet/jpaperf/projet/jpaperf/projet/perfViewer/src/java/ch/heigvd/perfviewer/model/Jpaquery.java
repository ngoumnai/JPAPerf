/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Jpaquery.findAll", query = "SELECT j FROM Jpaquery j"),
    @NamedQuery(name = "Jpaquery.findById", query = "SELECT j FROM Jpaquery j WHERE j.id = :id"),
    @NamedQuery(name = "Jpaquery.findByEntityqueried", query = "SELECT j FROM Jpaquery j WHERE j.entityqueried = :entityqueried"),
    @NamedQuery(name = "Jpaquery.findByExecutiondate", query = "SELECT j FROM Jpaquery j WHERE j.executiondate = :executiondate"),
    @NamedQuery(name = "Jpaquery.findByExecutiontime", query = "SELECT j FROM Jpaquery j WHERE j.executiontime = :executiontime"),
    @NamedQuery(name = "Jpaquery.findByJpql", query = "SELECT j FROM Jpaquery j WHERE j.jpql = :jpql"),
    @NamedQuery(name = "Jpaquery.findByQueryname", query = "SELECT j FROM Jpaquery j WHERE j.queryname = :queryname"),
    @NamedQuery(name = "Jpaquery.findBySqlquery", query = "SELECT j FROM Jpaquery j WHERE j.sqlquery = :sqlquery")})
public class Jpaquery implements Serializable {
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
    @ManyToMany
    private Collection<Jpaqueryexecution> jpaqueryexecutionCollection;

    public Jpaquery() {
    }

    public Jpaquery(Long id) {
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
    public Collection<Jpaqueryexecution> getJpaqueryexecutionCollection() {
        return jpaqueryexecutionCollection;
    }

    public void setJpaqueryexecutionCollection(Collection<Jpaqueryexecution> jpaqueryexecutionCollection) {
        this.jpaqueryexecutionCollection = jpaqueryexecutionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jpaquery)) {
            return false;
        }
        Jpaquery other = (Jpaquery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.perfviewer.model.Jpaquery[ id=" + id + " ]";
    }
    
}
