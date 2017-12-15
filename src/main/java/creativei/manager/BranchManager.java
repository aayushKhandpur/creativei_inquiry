package creativei.manager;

import creativei.entity.Branch;

import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
public interface BranchManager {
    List<Branch> getAll();
    Branch create(Branch branch);
    Branch findBranch(Long id);
}
