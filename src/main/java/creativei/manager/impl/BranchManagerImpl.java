package creativei.manager.impl;

import creativei.entity.Branch;
import creativei.manager.BranchManager;
import creativei.service.BranchService;
import creativei.vo.ResponseObject;
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
    public ResponseObject getAll() {
        return null;
    }

    @Override
    public ResponseObject create(Branch branch) {
        return null;
    }

    @Override
    public ResponseObject getById(Long id) {
        return null;
    }

    @Override
    public ResponseObject getByName(String name) {
        return null;
    }

    @Override
    public ResponseObject createAll(List<Branch> branches) {
        return null;
    }

    @Override
    public ResponseObject update(Branch branch) {
        return null;
    }

    @Override
    public ResponseObject updateAll(List<Branch> branches) {
        return null;
    }
}
