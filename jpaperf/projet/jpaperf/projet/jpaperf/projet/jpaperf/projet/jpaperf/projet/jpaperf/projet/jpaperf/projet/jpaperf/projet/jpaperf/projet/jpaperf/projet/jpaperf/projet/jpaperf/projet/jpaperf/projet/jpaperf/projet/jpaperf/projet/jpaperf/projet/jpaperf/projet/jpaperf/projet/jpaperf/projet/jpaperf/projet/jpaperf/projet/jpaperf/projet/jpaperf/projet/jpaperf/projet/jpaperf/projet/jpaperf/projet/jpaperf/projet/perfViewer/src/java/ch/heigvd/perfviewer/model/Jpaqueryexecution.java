/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "JPAQUERYEXECUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jpaqueryexecution.findAll", query = "SELECT j FROM Jpaqueryexecution j"),
    @NamedQuery(name = "Jpaqueryexecution.findById", query = "SELECT j FROM Jpaqueryexecution j WHERE j.id = :id"),
    @NamedQuery(name = "Jpaqueryexecution.findByQuery", query = "SELECT j FROM Jpaqueryexecution j WHERE j.query = :query"),
    @NamedQuery(name = "Jpaqueryexecution.findBySqlquery", query = "SELECT j FROM Jpaqueryexecution j WHERE j.sqlquery = :sqlquery")})
public class Jpaqueryexecution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "QUERY")
    private String query;
    @Size(max = 255)
    @Column(name = "SQLQUERY")
    private String sqlquery;
    @ManyToMany(mappedBy = "jpaqueryexecutionCollection")
    private Collection<Jpaquery> jpaqueryCollection;

    public Jpaqueryexecution() {
    }

    public Jpaqueryexecution(Long id) {
        this.id = id;
    }

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

    public String getSqlquery() {
        return sqlquery;
    }

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    @XmlTransient
    public Collection<Jpaquery> getJpaqueryCollection() {
        return jpaqueryCollection;
    }

    public void setJpaqueryCollection(Collection<Jpaquery> jpaqueryCollection) {
        this.jpaqueryCollection = jpaqueryCollection;
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
        if (!(object instanceof Jpaqueryexecution)) {
            return false;
        }
        Jpaqueryexecution other = (Jpaqueryexecution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.perfviewer.model.Jpaqueryexecution[ id=" + id + " ]";
    }
    
}
