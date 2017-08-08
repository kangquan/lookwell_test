package cn.bdqn.tangcco.service.impl;

import cn.bdqn.tangcco.dao.ProjectMapper;
import cn.bdqn.tangcco.entity.Project;
import cn.bdqn.tangcco.service.ProjectService;
import cn.bdqn.tangcco.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/8/5.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Inject
    private ProjectMapper projectMapper;
    @Override
    public PageUtil<Project> queryAllProject(Integer page, Integer rows) {
        PageUtil pageUtil = new PageUtil(page,rows);
        Integer start = pageUtil.getStart();
        Integer count = projectMapper.queryCountProject();
        List<Project> list = projectMapper.queryAllProject(start,rows);
        pageUtil.setTotal(count);
        pageUtil.setObjs(list);
        return pageUtil;
    }

    @Override
    public Project detailProject(Integer project) {
        return projectMapper.detailProject(project);
    }

    @Override
    public Integer addProject(Project project) {
        project.setCreateTime(new Date());
        project.setUpdateTime(new Date());
        return projectMapper.addProject(project);
    }

    @Override
    public Integer updateProject(Project project) {
        project.setUpdateTime(new Date());
        return projectMapper.updateProject(project);
    }

    @Override
    public Integer deleteProjectByList(List<Integer> idList) {
        return projectMapper.deleteProjectByList(idList);
    }


}
