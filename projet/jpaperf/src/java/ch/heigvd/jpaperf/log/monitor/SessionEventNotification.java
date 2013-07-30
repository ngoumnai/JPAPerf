/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.monitor;

import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventListener;

/**
 * Aims to receive notifications of events during the session.
 * @author gauss
 */
public class SessionEventNotification implements SessionEventListener{

    /**
     *  This event is raised on the session if a descriptor is missing for a class being persisted.
     * @param se 
     */
    @Override
    public void missingDescriptor(SessionEvent se) {
        System.out.println("Pas de descripteur pour l'élément persiste\n" + se.toString());
    }

    /**
     * This event is raised on the session after read object query detected more 
     * than a single row back from the database.
     * @param se 
     */
    @Override
    public void moreRowsDetected(SessionEvent se) {
        System.out.println("Plus d'une colonne a retourner\n" + se.toString());
    }

    /**
     * This event is raised on the session after update or delete SQL has been sent to the database 
     * but a row count of zero was returned.
     * @param se 
     */
    @Override
    public void noRowsModified(SessionEvent se) {
        System.out.println("requete SQL sur une table qui n'existe pas\n" + se.toString());
    }

    /**
     * This event is raised on the session after a stored procedure call has been 
     * executed that had output parameters.
     * @param se 
     */
    @Override
    public void outputParametersDetected(SessionEvent se) {
        System.out.println("Element a retourner apres un enregistrement\n" + se.toString());
    }

    /**
     * This event is raised on the client session after creation/acquiring.
     * @param se 
     */
    @Override
    public void postAcquireClientSession(SessionEvent se) {
        System.out.println("Session creee\n" + se.toString());
    }

    /**
     * This event is raised on when using the server/client sessions.
     * @param se 
     */
    @Override
    public void postAcquireConnection(SessionEvent se) {
        System.out.println("Session du serveur/client utilisee\n" + se.toString());
    }

    /**
     *  This event is raised when a ClientSession, with Isolated data, acquires 
     *  an exclusive connection.
     * @param se 
     */
    @Override
    public void postAcquireExclusiveConnection(SessionEvent se) {
        System.out.println("Session client exclusive avec des donnees isolees\n" + se.toString());
    }

    /**
     * This event is raised on the unit of work after creation/acquiring.
     * @param se 
     */
    @Override
    public void postAcquireUnitOfWork(SessionEvent se) {
        System.out.println("Creation ou acquisition de l'unite de travail\n" + se.toString());
    }

    /**
     * This event is raised after a database transaction is started.
     * @param se 
     */
    @Override
    public void postBeginTransaction(SessionEvent se) {
        System.out.println("Debut d'une trasaction depuis la base de donnees\n" + se.toString());
    }

    /**
     * This event is raised after the commit has begun on the UnitOfWork but 
     * before the changes are calculated.
     * @param se 
     */
    @Override
    public void preCalculateUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("Le commit a commence sur l'unite de travail et le changement "
                + "n'a pas ebcore ete calcule\n" + se.toString());
    }

    /**
     * This event is raised after the commit has begun on the UnitOfWork and 
     * after the changes are calculated.
     * @param se 
     */
    @Override
    public void postCalculateUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("Le commit a commence sur l'unite de travail et le changement "
                + "a deja ete calcule\n" + se.toString());
    }

    /**
     *  This event is raised after a database transaction is commited.
     * @param se 
     */
    @Override
    public void postCommitTransaction(SessionEvent se) {
        System.out.println("La transaction depuis la base de donnees a ete comitee\n" + se.toString());
    }

    /**
     * This event is raised on the unit of work after commit.
     * @param se 
     */
    @Override
    public void postCommitUnitOfWork(SessionEvent se) {
         System.out.println("Le commit de l'unite de travail a ete effectue\n" + se.toString());
    }

    /**
     * This event is raised after the session connects to the database.
     * @param se 
     */
    @Override
    public void postConnect(SessionEvent se) {
        System.out.println("La session c'est connectee a la base de donnees\n" + se.toString());
    }

    @Override
    public void postExecuteQuery(SessionEvent se) {
        System.out.println("postExecuteQuery\n" + se.toString());
    }

    @Override
    public void postReleaseClientSession(SessionEvent se) {
        System.out.println("postReleaseClientSession\n" + se.toString());
    }

    @Override
    public void postReleaseUnitOfWork(SessionEvent se) {
        System.out.println("postReleaseUnitOfWork\n" + se.toString());
    }

    @Override
    public void postResumeUnitOfWork(SessionEvent se) {
        System.out.println("postResumeUnitOfWork\n" + se.toString());
    }

    @Override
    public void postRollbackTransaction(SessionEvent se) {
        System.out.println("postRollbackTransaction\n" + se.toString());
    }

    @Override
    public void postDistributedMergeUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("postDistributedMergeUnitOfWorkChangeSet\n" + se.toString());
    }

    @Override
    public void postMergeUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("postMergeUnitOfWorkChangeSet\n" + se.toString());
    }

    @Override
    public void preBeginTransaction(SessionEvent se) {
        System.out.println("preBeginTransaction\n" + se.toString());
    }

    @Override
    public void preCommitTransaction(SessionEvent se) {
        System.out.println("preCommitTransaction\n" + se.toString());
    }

    @Override
    public void preCommitUnitOfWork(SessionEvent se) {
        System.out.println("preCommitUnitOfWork\n" + se.toString());
    }

    @Override
    public void preExecuteQuery(SessionEvent se) {
        System.out.println("preExecuteQuery\n" + se.toString());
    }

    @Override
    public void prepareUnitOfWork(SessionEvent se) {
        System.out.println("prepareUnitOfWork\n" + se.toString());
    }

    @Override
    public void preReleaseClientSession(SessionEvent se) {
        System.out.println("preReleaseClientSession\n" + se.toString());
    }

    @Override
    public void preReleaseConnection(SessionEvent se) {
        System.out.println("preReleaseConnection\n" + se.toString());
    }

    @Override
    public void preReleaseExclusiveConnection(SessionEvent se) {
        System.out.println("preReleaseExclusiveConnection\n" + se.toString());
    }

    @Override
    public void preReleaseUnitOfWork(SessionEvent se) {
        System.out.println("preReleaseUnitOfWork\n" + se.toString());
    }

    @Override
    public void preRollbackTransaction(SessionEvent se) {
        System.out.println("preRollbackTransaction\n" + se.toString());
    }

    @Override
    public void preDistributedMergeUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("preDistributedMergeUnitOfWorkChangeSet\n" + se.toString());
    }

    @Override
    public void preMergeUnitOfWorkChangeSet(SessionEvent se) {
        System.out.println("preMergeUnitOfWorkChangeSet\n" + se.toString());
    }

    @Override
    public void preLogin(SessionEvent se) {
        System.out.println("preLogin\n" + se.toString());
    }

    @Override
    public void postLogin(SessionEvent se) {
        System.out.println("postLogin\n" + se.toString());
    }

    @Override
    public void preLogout(SessionEvent se) {
        System.out.println("preLogout\n" + se.toString());
    }

    @Override
    public void postLogout(SessionEvent se) {
        System.out.println("postLogout\n" + se.toString());
    }
    
}
