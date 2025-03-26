/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author mah
 */
public interface IDAO<T, K> {

    public boolean createNewProject(T entity);

    public List<T> readAll();

    public T readById(K id);

    public boolean updateProjectStatus(T entity);

    public List<T> searchByName(String searchTerm);

}
