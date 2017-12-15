package creativei.service;

import creativei.entity.Branch;

import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
public interface BranchService {
    List<Branch> getAll();
    Branch create(Branch branch);
    Branch findBranch(Long id);

}
