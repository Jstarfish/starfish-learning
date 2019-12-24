package priv.starfish.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.starfish.department.dao.DepartmentDao;
import priv.starfish.department.model.Department;
import priv.starfish.department.service.DepartmentService;

import java.util.List;

/**
 * Created by starfish on 2017/8/31.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.findAll();
    }
}
