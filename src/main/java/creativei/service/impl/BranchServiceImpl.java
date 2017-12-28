package creativei.service.impl;

import creativei.dao.BranchDao;
import creativei.entity.Branch;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.BranchService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("BranchService")
public class BranchServiceImpl implements BranchService {
    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);
    @Autowired
    private BranchDao branchDao;
    @Override
    public List<Branch> getAll() {
        return branchDao.findAll();
    }

    @Override
    public Branch create(Branch branch) throws UniqueConstraintViolationException, DataIntegrityException {
        try {
            return branchDao.save(branch);
        }catch (DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                throw UniqueConstraintViolationException.getInstance(ce.getConstraintName(), ce.getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }

    }

    @Override
    public Branch getById(Long id) {
        return null;
    }

    @Override
    public Branch getByName(String name) {
        return null;
    }

    @Override
    public Branch createAll(List<Branch> branches) {
        return null;
    }

    @Override
    public Branch update(Branch branch) {
        return null;
    }

    @Override
    public Branch updateAll(List<Branch> branches) {
        return null;
    }

}
