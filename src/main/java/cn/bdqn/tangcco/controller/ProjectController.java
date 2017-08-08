package cn.bdqn.tangcco.controller;

import cn.bdqn.tangcco.entity.Project;
import cn.bdqn.tangcco.service.ProjectService;
import cn.bdqn.tangcco.tools.Message;
import cn.bdqn.tangcco.tools.PageUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/8/5.
 */
@Controller
public class ProjectController {
    @Inject
    private ProjectService projectService;

    @RequestMapping(value = "project/toProjectList",method = RequestMethod.GET)
    public String toProject() {
        return "projectList";
    }

    @RequestMapping(value = "projectList",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String projectList(Integer page,Integer rows) {

        Map<String, Object> map = new HashMap<>();
        PageUtil<Project> pageUtil =projectService.queryAllProject(page,rows);
        map.put("total",pageUtil.getTotal());
        map.put("rows",pageUtil.getObjs());
        return JSONArray.toJSONString(map);
    }
    @RequestMapping(value = "addProject",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addProject(Project project) {
        Integer count = projectService.addProject(project);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("新增成功");
        } else {
            msg.setMsg("新增失败");
        }
        return JSONArray.toJSONString(msg);
    }
    @RequestMapping(value = "detailProject",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String detailProject(Integer projectId) {
        return JSONArray.toJSONString(projectService.detailProject(projectId));
    }
    @RequestMapping(value = "updateProject",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateProject(Project project){
        Integer count = projectService.updateProject(project);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("修改成功");
        } else {
            msg.setMsg("修改失败");
        }
        return JSONArray.toJSONString(msg);
    }
    @RequestMapping(value = "deleteProjectList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteProjectList(String projectIdList) {
        String[] idStrArray=projectIdList.split(",");
        List<Integer> idList=new ArrayList<>();
        for(int i=0;i<idStrArray.length;i++){
            idList.add(Integer.parseInt(idStrArray[i]));
        }
        Integer n=projectService.deleteProjectByList(idList);
        Message msg=new Message();
        if(n>0){
            msg.setMsg("删除成功");
        }else{
            msg.setMsg("删除失败");
        }
        return JSONArray.toJSONString(msg);
    }

}
