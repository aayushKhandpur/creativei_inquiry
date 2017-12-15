package creativei.manager.impl;

import creativei.entity.Branch;
import creativei.manager.BranchManager;
import creativei.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
@Service
public class BranchManagerImpl implements BranchManager {
    @Autowired
    BranchService branchService;
    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public Branch create(Branch branch) {
        return branchService.create(branch);
    }

    @Override
    public Branch findBranch(Long id) {
        return null;
    }
}
