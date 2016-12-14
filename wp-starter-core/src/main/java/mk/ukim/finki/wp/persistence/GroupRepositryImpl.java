package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/14/16.
 */
public class GroupRepositryImpl implements GroupRepository {

    EntityManagerFactory mEMFactory;
    EntityManager mEmMgr;
    private CriteriaBuilder mCriteriaBuilder;
    private Metamodel mMetaModel;
    private EntityType<Group> Group_;

    public GroupRepositryImpl() {
        mEMFactory = Persistence.createEntityManagerFactory( "Lab07" );
        mEmMgr = mEMFactory.createEntityManager();
        mCriteriaBuilder = mEmMgr.getCriteriaBuilder();
        mMetaModel = mEMFactory.getMetamodel();
        Group_ = mMetaModel.entity(Group.class);
    }


    public List<Group> findAll() {
        CriteriaQuery<Object> criteriaQuery = mCriteriaBuilder.createQuery();
        Root<Group> from = criteriaQuery.from(Group.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);

        TypedQuery<Object> typedQuery = mEmMgr.createQuery(select);
        List<Object> resultlist = typedQuery.getResultList();

        return (List<Group>)(Object) resultlist;
    }

    public Group findById(Long id) {
        CriteriaQuery<Object> criteriaQuery = mCriteriaBuilder.createQuery();

        Root<Group> from = criteriaQuery.from(Group.class);
        criteriaQuery.where(from.get(Group_.getId(Long.class)).in(id));

        CriteriaQuery<Object> select = criteriaQuery.select(from);
        TypedQuery<Object> typedQuery = mEmMgr.createQuery(select);

        return (Group) typedQuery.getSingleResult() ;
    }

    public void save(Group entity) {
        mEmMgr.getTransaction().begin();
        mEmMgr.persist(entity);
        mEmMgr.getTransaction().commit();
    }

    public void update(Long id, Group entity) {
        //
        // Group old = mEmMgr.find(Group.class, entity.getId());

        mEmMgr.getTransaction().begin();
        mEmMgr.merge(entity);
        mEmMgr.getTransaction().commit();
    }

    public void delete(Long id) {
        Group old = mEmMgr.find(Group.class, id);
        mEmMgr.getTransaction().begin();
        mEmMgr.remove(old);
        mEmMgr.getTransaction().commit();
    }
}
