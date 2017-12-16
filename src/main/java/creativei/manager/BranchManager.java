package creativei.manager;

import creativei.entity.Branch;
import creativei.vo.ResponseObject;


import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
public interface BranchManager {
    ResponseObject getAll();
    ResponseObject create(Branch branch);
    ResponseObject getById(Long id);
    ResponseObject getByName(String name);
    ResponseObject createAll(List<Branch> branches);
    ResponseObject update(Branch branch);
    ResponseObject updateAll(List<Branch> branches);
}
