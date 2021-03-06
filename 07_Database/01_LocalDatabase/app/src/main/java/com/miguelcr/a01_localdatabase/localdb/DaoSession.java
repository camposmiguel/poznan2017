package com.miguelcr.a01_localdatabase.localdb;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.miguelcr.a01_localdatabase.localdb.Students;
import com.miguelcr.a01_localdatabase.localdb.Subjects;

import com.miguelcr.a01_localdatabase.localdb.StudentsDao;
import com.miguelcr.a01_localdatabase.localdb.SubjectsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentsDaoConfig;
    private final DaoConfig subjectsDaoConfig;

    private final StudentsDao studentsDao;
    private final SubjectsDao subjectsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentsDaoConfig = daoConfigMap.get(StudentsDao.class).clone();
        studentsDaoConfig.initIdentityScope(type);

        subjectsDaoConfig = daoConfigMap.get(SubjectsDao.class).clone();
        subjectsDaoConfig.initIdentityScope(type);

        studentsDao = new StudentsDao(studentsDaoConfig, this);
        subjectsDao = new SubjectsDao(subjectsDaoConfig, this);

        registerDao(Students.class, studentsDao);
        registerDao(Subjects.class, subjectsDao);
    }
    
    public void clear() {
        studentsDaoConfig.getIdentityScope().clear();
        subjectsDaoConfig.getIdentityScope().clear();
    }

    public StudentsDao getStudentsDao() {
        return studentsDao;
    }

    public SubjectsDao getSubjectsDao() {
        return subjectsDao;
    }

}
