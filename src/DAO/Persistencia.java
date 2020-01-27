/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;



/**
 * Interface para persistencia de dados que sera usada para implementar o DAO.
 * @author rafa_
 */
public interface Persistencia<T> {
    public int create (T obj);
    public List<T> read();
    public boolean update(T obj);
    public boolean delete(T obj);
    public T findByCodigo (int id);
    
}
