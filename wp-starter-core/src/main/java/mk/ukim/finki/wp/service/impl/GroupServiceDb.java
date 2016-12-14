package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Group;
import mk.ukim.finki.wp.persistence.GroupRepository;
import mk.ukim.finki.wp.persistence.GroupRepositryImpl;
import mk.ukim.finki.wp.service.GroupService;

import java.util.List;

/**
 * Created by user on 12/14/16.
 */
public class GroupServiceDb implements GroupService {
    GroupRepository repo;

    public GroupServiceDb() {
        repo = new GroupRepositryImpl();
    }

    public List<Group> findAll() {
        return repo.findAll();
    }

    public Group findById(Long id) {
        return repo.findById(id);
    }

    public void save(Group entity) {
        repo.save(entity);
    }

    public void update(Long id, Group entity) {
        repo.update(id, entity);
    }

    public void delete(Long id) {
        repo.delete(id);
    }
}
