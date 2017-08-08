package cn.bdqn.tangcco.Test;

import cn.bdqn.tangcco.entity.Project;
import cn.bdqn.tangcco.service.ProjectService;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by admin on 2017/8/6.
 */
public class TestProject extends Base {
    @Inject
    private ProjectService projectService;

    @Test
    public void testupdate() {
        Date now = new Date();
        Project p = new Project();
        p.setProjectId(53);
        p.setProjectName("aaa11");
        p.setProjectDesc("aaa11");
        p.setProjectVersion("111111");
        p.setProjectStatus("aa11");
        p.setUpdateTime(now);
        System.out.println(projectService.updateProject(p));
    }
}
