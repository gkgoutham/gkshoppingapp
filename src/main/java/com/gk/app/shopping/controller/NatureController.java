package com.gk.app.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gk.app.shopping.bean.Tree;
import com.gk.app.shopping.dao.MongoRepository;

@RestController
public class NatureController {

	@Autowired
	private MongoRepository<Tree> treeRepository;

	/**
	 * @return
	 */
	@RequestMapping(value = "/trees", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Tree> getCountries() {
		return treeRepository.getAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/tree/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Tree getTreeById(@PathVariable String id) {
		return treeRepository.get(id);
	}

	/**
	 * @param tree
	 * @return
	 */
	@RequestMapping(value = "/trees", method = RequestMethod.POST, headers = "Accept=application/json")
	public Tree addTree(@RequestBody Tree tree) {
		treeRepository.save(tree);
		return treeRepository.get(tree.getId());
	}

	/**
	 * @param id
	 * @param name
	 */
	@RequestMapping(value = "/trees", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateTree(@RequestParam String id, @RequestParam String name) {
		treeRepository.update(id, name);
	}

	/**
	 * @param id
	 */
	@RequestMapping(value = "/tree/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteTree(@PathVariable("id") String id) {
		treeRepository.delete(id);

	}
}
