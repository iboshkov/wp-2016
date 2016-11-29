package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.service.GroupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 131223 on 11/29/2016.
 */
public class GroupServiceImpl implements GroupService {
    static Map<Long, Group> idToGroup = new HashMap<Long, Group>();
    static long idCounter = 0;

    @Override
    public List<Group> findAll() {
        return new ArrayList(idToGroup.values());
    }

    @Override
    public Group findById(Long id) {
        return idToGroup.get(id);
    }

    @Override
    public void save(Group entity) {
        entity.setId(idCounter++);
        idToGroup.put(entity.getId(), entity);
    }

    @Override
    public void update(Long id, Group entity) {
        idToGroup.put(id, entity);
    }

    @Override
    public void delete(Long id) {
        idToGroup.remove(id);
    }
}
