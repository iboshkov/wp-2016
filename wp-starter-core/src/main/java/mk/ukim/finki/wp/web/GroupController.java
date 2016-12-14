package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.GroupService;
import mk.ukim.finki.wp.service.impl.GroupServiceDb;
import mk.ukim.finki.wp.service.impl.GroupServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by 131223 on 11/29/2016.
 */
@RestController
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "api/groups")
    public List<Group> findAll (HttpSession session) {
        GroupService svc = new GroupServiceDb();
        List<Group> test = svc.findAll();

        return test;
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/groups/{id}")
    public Group findById (@PathVariable(value="id") Long id, HttpSession session) {
        GroupService svc = new GroupServiceDb();

        return svc.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/groups")
    public void save (@RequestBody Group group,HttpSession session) {
        GroupService svc = new GroupServiceDb();
        svc.save(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/groups")
    public void update (@RequestBody Group group,HttpSession session) {
        GroupService svc = new GroupServiceDb();
        svc.update(group.getId(), group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "api/groups/{id}")
    public void delete (@PathVariable(value = "id") Long id,HttpSession session) {
        GroupService svc = new GroupServiceDb();
        svc.delete(id);
    }
}
