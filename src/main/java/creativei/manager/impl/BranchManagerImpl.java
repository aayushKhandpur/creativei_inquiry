package creativei.manager.impl;

import creativei.controller.BranchController;
import creativei.entity.Branch;
import creativei.enums.ExceptionType;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;
import creativei.helper.ResponseHelper;
import creativei.manager.BranchManager;
import creativei.service.BranchService;
import creativei.vo.BranchVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aayush on 12/15/2017.
 */
@Service
public class BranchManagerImpl implements BranchManager {
    private static final Logger logger = LoggerFactory.getLogger(BranchManagerImpl.class);

    @Autowired
    BranchService branchService;

    @Override
    public ResponseObject getAll() {
        return null;
    }

    @Override
    public ResponseObject create(BranchVo branchVo) {
        try {
            Branch branch = new Branch(branchVo);
            branch = branchService.create(branch);//branchService().create saves and returns the saved branch in dao
            branchVo = ResponseHelper.getCreateBranchResponseData(branch, branchVo);//?
            return ResponseObject.getResponse(branchVo);
        }catch (UniqueConstraintViolationException ue){
            logger.error(ue.getMessage(),ue);
            //using temp error code and message. To be updated after implementing exception handling module.
            return ResponseObject.getResponse(ue.getMessage(), ExceptionType.DUPLICATE_VALUE.getCode());
        } catch (DataIntegrityException de) {
            logger.error(de.getMessage(), de);
            //using temp error code and message. To be updated after implementing exception handling module.
            return ResponseObject.getResponse(ExceptionType.DATABASE_EXCEPTION.getMessage(), ExceptionType.DATABASE_EXCEPTION.getCode());
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());

        }
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
