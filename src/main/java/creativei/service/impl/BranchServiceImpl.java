package creativei.service.impl;

import creativei.dao.BranchDao;
import creativei.entity.Branch;
import creativei.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
@Service("BranchService")
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchDao branchDao;
    @Override
    public List<Branch> getAll() {
        return branchDao.findAll();
    }

    @Override
    public Branch create(Branch branch) {
        return branchDao.save(branch);
    }

    @Override
    public Branch findBranch(Long id) {
        return null;
    }
}
