package cn.bdqn.tangcco.dao;

import cn.bdqn.tangcco.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/8/5.
 */
public interface ProjectMapper {
    public List<Project> queryAllProject(@Param("start")Integer start,@Param("rows")Integer rows);
    public Project detailProject(Integer projectId);
    public Integer queryCountProject();
    public Integer addProject(Project project);
    public Integer updateProject(Project project);
    public Integer deleteProjectByList(List<Integer> idList);
}
