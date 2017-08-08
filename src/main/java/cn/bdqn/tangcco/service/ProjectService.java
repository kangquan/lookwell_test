package cn.bdqn.tangcco.service;

import cn.bdqn.tangcco.entity.Project;
import cn.bdqn.tangcco.tools.PageUtil;

import java.util.List;

/**
 * Created by admin on 2017/8/5.
 */
public interface ProjectService {
    public PageUtil<Project> queryAllProject(Integer page,Integer rows);
    public Project detailProject(Integer project);
    public Integer addProject(Project project);
    public Integer updateProject(Project project);
    public Integer deleteProjectByList(List<Integer> idList);
}
