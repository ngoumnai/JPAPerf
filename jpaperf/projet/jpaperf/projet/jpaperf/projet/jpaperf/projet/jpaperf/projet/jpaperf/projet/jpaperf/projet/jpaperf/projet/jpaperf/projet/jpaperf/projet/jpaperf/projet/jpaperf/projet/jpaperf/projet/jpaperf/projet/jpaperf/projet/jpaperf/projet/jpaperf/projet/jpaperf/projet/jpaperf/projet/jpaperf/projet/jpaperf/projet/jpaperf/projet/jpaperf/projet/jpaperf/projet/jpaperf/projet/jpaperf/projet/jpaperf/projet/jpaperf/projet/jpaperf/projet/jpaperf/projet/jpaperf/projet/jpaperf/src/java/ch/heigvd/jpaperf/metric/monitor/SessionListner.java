/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.monitor;

import ch.heigvd.jpaperf.metric.model.JPAQuery;
import ch.heigvd.jpaperf.metric.model.JPAQueryExecution;
import ch.heigvd.jpaperf.metric.service.JPAQueryExecutionManagerLocal;
import ch.heigvd.jpaperf.metric.service.JPAQueryManagerLocal;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventListener;

/**
 * Aims to receive notifications of events during the session.
 * Used to support session events. To register for events notification an event 
 * listener must be registered with the session. 
 * @author gauss
 */
public class SessionListner implements SessionEventListener{
    //We use lookup because this class is not an EJB
    JPAQueryManagerLocal jpaQueryManager;
    JPAQueryExecutionManagerLocal jpaQueryExecutionManager;
    JPAQuery jpaQuery;
    JPAQueryExecution jpaQueryExecution;
    
    public SessionListner(){
        jpaQuery = new JPAQuery();
    }
    
    /**
     *  This event is raised on the session if a descriptor is missing for a class being persisted.
     * @param se 
     */
    @Override
    public void missingDescriptor(SessionEvent se) {
    System.out.println("missingDescriptor\n");
    }

    /**
     * This event is raised on the session after read object query detected more 
     * than a single row back from the database.
     * @param se 
     */
    @Override
    public void moreRowsDetected(SessionEvent se) {
    System.out.println("moreRowsDetected\n");
    }

    /**
     * This event is raised on the session after update or delete SQL has been sent to the database 
     * but a row count of zero was returned.
     * @param se 
     */
    @Override
    public void noRowsModified(SessionEvent se) {
    System.out.println("noRowsModified\n");}

    /**
     * This event is raised on the session after a stored procedure call has been 
     * executed that had output parameters.
     * @param se 
     */
    @Override
    public void outputParametersDetected(SessionEvent se) {System.out.println("outputParametersDetected\n");}

    /**
     * This event is raised on the client session after creation/acquiring.
     * @param se 
     */
    @Override
    public void postAcquireClientSession(SessionEvent se) {System.out.println("postAcquireClientSession\n");}

    /**
     * This event is raised on when using the server/client sessions.
     * @param se 
     */
    @Override
    public void postAcquireConnection(SessionEvent se) {System.out.println("postAcquireConnection\n");}

    /**
     *  This event is raised when a ClientSession, with Isolated data, acquires 
     *  an exclusive connection.
     * @param se 
     */
    @Override
    public void postAcquireExclusiveConnection(SessionEvent se) {System.out.println("postAcquireExclusiveConnection\n");}

    /**
     * This event is raised on the unit of work after creation/acquiring.
     * @param se 
     */
    @Override
    public void postAcquireUnitOfWork(SessionEvent se) {System.out.println("postAcquireUnitOfWork\n");}

    /**
     * This event is raised after a database transaction is started.
     * We use it to initialize the JPAQuery item and trigger the timer
     * @param se 
     */
    @Override
    public void postBeginTransaction(SessionEvent se) {System.out.println("postBeginTransaction\n");}

    /**
     * This event is raised after the commit has begun on the UnitOfWork but 
     * before the changes are calculated.
     * @param se 
     */
    @Override
    public void preCalculateUnitOfWorkChangeSet(SessionEvent se) { System.out.println("preCalculateUnitOfWorkChangeSet\n");}

    /**
     * This event is raised after the commit has begun on the UnitOfWork and 
     * after the changes are calculated.
     * @param se 
     */
    @Override
    public void postCalculateUnitOfWorkChangeSet(SessionEvent se) {System.out.println("postCalculateUnitOfWorkChangeSet\n");}

    /**
     *  This event is raised after a database transaction is commited.
     * @param se 
     */
    @Override
    public void postCommitTransaction(SessionEvent se) {System.out.println("postCommitTransaction\n");}

    /**
     * This event is raised on the unit of work after commit.
     * @param se 
     */
    @Override
    public void postCommitUnitOfWork(SessionEvent se) {
        
        
        System.out.println("postCommitUnitOfWork\n");
    }

    /**
     * This event is raised after the session connects to the database.
     * @param se 
     */
    @Override
    public void postConnect(SessionEvent se) {System.out.println("postConnect\n");}

    /**
     * This event is raised after the execution of every query against the session.
     * @param se 
     */
    @Override
    public void postExecuteQuery(SessionEvent se) {
         
        
        System.out.println("postExecuteQuery\n" 
                + se.getQuery());
    }

    /**
     * This event is raised on the client session after releasing.
     * @param se 
     */
    @Override
    public void postReleaseClientSession(SessionEvent se) {System.out.println("postReleaseClientSession\n");}

    /**
     * This event is raised on the unit of work after release.This will be raised on nest units of work. 
     * @param se 
     */
    @Override
    public void postReleaseUnitOfWork(SessionEvent se) {System.out.println("postReleaseUnitOfWork\n");}

    /**
     *  This event is raised on the unit of work after resuming. This occurs after pre/postCommit. 
     * @param se 
     */
    @Override
    public void postResumeUnitOfWork(SessionEvent se) {System.out.println("postResumeUnitOfWork\n");}

    /**
     * This event is raised after a database transaction is rolledback. 
     * It is not raised for nested transactions. 
     * @param se 
     */
    @Override
    public void postRollbackTransaction(SessionEvent se) {System.out.println("postRollbackTransaction\n");}

    /**
     * This even will be raised after a UnitOfWorkChangeSet has been merged When 
     * that changeSet has been received from a distributed session 
     * @param se 
     */
    @Override
    public void postDistributedMergeUnitOfWorkChangeSet(SessionEvent se) {System.out.println("postDistributedMergeUnitOfWorkChangeSet\n");}

    /**
     * This even will be raised after a UnitOfWorkChangeSet has been merged 
     * @param se 
     */
    @Override
    public void postMergeUnitOfWorkChangeSet(SessionEvent se) {System.out.println("postMergeUnitOfWorkChangeSet\n");}

    /**
     * This event is raised before a database transaction is started. 
     * It is not raised for nested transactions. 
     * @param se 
     */
    @Override
    public void preBeginTransaction(SessionEvent se) {System.out.println("preBeginTransaction\n");}

    /**
     * This event is raised before a database transaction is commited. 
     * It is not raised for nested transactions. 
     * @param se 
     */
    @Override
    public void preCommitTransaction(SessionEvent se) {
        System.out.println("preCommitTransaction\n");
    }

    /**
     * This event is raised on the unit of work before commit.
     * This will be raised on nest units of work.
     * @param se 
     */
    @Override
    public void preCommitUnitOfWork(SessionEvent se) {
        if (jpaQuery.getQueryName() != null){
            persistData();
        }
        
        
        System.out.println("preCommitUnitOfWork\n");
    }

    /**
     * This event is raised before the execution of every query against the session.
     * The event contains the query to be executed. 
     * @param se 
     */
    @Override
    public void preExecuteQuery(SessionEvent se) {
        
        System.out.println("preExecuteQuery\n" 
                + se.getQuery());
        
        reapData(se);
        
    }

    /**
     * This event is raised on the unit of work after the SQL has been flushed,
     * but the commit transaction has not been executed. It is similar to the JTS prepare phase. 
     * @param se 
     */
    @Override
    public void prepareUnitOfWork(SessionEvent se) {
        if (jpaQuery.getQueryName() != null){
            persistData();
        }
        
        
        System.out.println("prepareUnitOfWork\n");
    }

    /**
     * This event is raised on the client session before releasing.
     * @param se 
     */
    @Override
    public void preReleaseClientSession(SessionEvent se) {
       
        
        System.out.println("preReleaseClientSession\n");
    }

    /**
     * This event is raised on when using the server/client sessions.
     * This event is raised before a connection is released into a connection pool. 
     * @param se 
     */
    @Override
    public void preReleaseConnection(SessionEvent se) {System.out.println("preReleaseConnection\n");}

    /**
     * This event is fired just before a Client Session, with isolated data, releases its Exclusive Connection 
     * @param se 
     */
    @Override
    public void preReleaseExclusiveConnection(SessionEvent se) {System.out.println("preReleaseExclusiveConnection\n");}

    /**
     *  This event is raised on the unit of work before release. This will be raised on nest units of work. 
     * @param se 
     */
    @Override
    public void preReleaseUnitOfWork(SessionEvent se) {System.out.println("preReleaseUnitOfWork\n");}

    /**
     *  This event is raised before a database transaction is rolledback. It is not raised for nested transactions. 
     * @param se 
     */
    @Override
    public void preRollbackTransaction(SessionEvent se) {System.out.println("preRollbackTransaction\n");}

    /**
     * This even will be raised before a UnitOfWorkChangeSet has been merged When 
     * that changeSet has been received from a distributed session 
     * @param se 
     */
    @Override
    public void preDistributedMergeUnitOfWorkChangeSet(SessionEvent se) {System.out.println("preDistributedMergeUnitOfWorkChangeSet\n");}

    /**
     * This even will be raised before a UnitOfWorkChangeSet has been merged 
     * @param se 
     */
    @Override
    public void preMergeUnitOfWorkChangeSet(SessionEvent se) {System.out.println("preMergeUnitOfWorkChangeSet\n");}

    /**
     * This Event is raised before the session logs in. 
     * @param se 
     */
    @Override
    public void preLogin(SessionEvent se) {System.out.println("preLogin\n");}

    /**
     * This Event is raised after the session logs in. 
     * @param se 
     */
    @Override
    public void postLogin(SessionEvent se) {System.out.println("postLogin\n");}

    @Override
    public void preLogout(SessionEvent se) {System.out.println("preLogout\n");}

    @Override
    public void postLogout(SessionEvent se) {System.out.println("postLogout\n");}

    private JPAQueryManagerLocal lookupJPAQueryManagerLocal() {
        try {
            Context c = new InitialContext();
            return (JPAQueryManagerLocal) c.lookup("java:global/jpaperf/JPAQueryManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "*** COULD NOT LOOKUP EJB");
            //throw new RuntimeException(ne);
            return null;
        }
    }
    
    private void persistData(){
            jpaQuery.setExecutionTime(Math.abs(jpaQuery.getExecutionTime() - Calendar.getInstance().getTimeInMillis()));

            if (jpaQueryManager == null) {
                jpaQueryManager = lookupJPAQueryManagerLocal();
            }
            if (jpaQueryExecutionManager == null) {
                jpaQueryExecutionManager = lookupJPAQueryExecutionManagerLocal();
            }
            
            for (JPAQueryExecution jpaE : jpaQuery.getJpaQueryExecution()) {
                jpaQueryExecutionManager.create(jpaQueryExecution);
            }
            
            jpaQueryManager.create(jpaQuery);
            jpaQuery = new JPAQuery();
    }
    
    private void reapData(SessionEvent se){
        if (jpaQuery.getQueryName() == null){
            if (se.getQuery().getName() != null){                
                jpaQuery.setQueryName(se.getQuery().getName());                
            }
            else{
                jpaQuery.setQueryName(se.getQuery().toString());
            }
            jpaQuery.setEntityQueried(se.getQuery().getReferenceClassName());
            jpaQuery.setExecutionDate(Calendar.getInstance().getTime().toString());
            jpaQuery.setExecutionTime(Calendar.getInstance().getTimeInMillis());
            jpaQuery.setJpql(se.getQuery().getJPQLString());
            jpaQuery.setSqlQuery(se.getQuery().getSQLString());
        }
        else{
            jpaQueryExecution = new JPAQueryExecution();
            jpaQueryExecution.setSqlQuery(se.getQuery().getSQLString());
            
            if (se.getQuery().getName() != null){                
                jpaQueryExecution.setQuery(se.getQuery().getName());                
            }
            else{
                jpaQueryExecution.setQuery(se.getQuery().toString());
            } 
            jpaQuery.addJpaQueryExecution(jpaQueryExecution);
        }
    }

    private JPAQueryExecutionManagerLocal lookupJPAQueryExecutionManagerLocal() {
        try {
            Context c = new InitialContext();
            return (JPAQueryExecutionManagerLocal) c.lookup("java:global/jpaperf/JPAQueryExecutionManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "*** COULD NOT LOOKUP EJB");
            //throw new RuntimeException(ne);
            return null;
        }
    }
}
