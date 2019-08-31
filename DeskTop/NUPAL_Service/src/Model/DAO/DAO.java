/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.List;

/**
 *
 * @author Barato Soft Solution
 */
public interface DAO <T>{
    public void Create(T x);
    public T Read(T x);
    public void Update(T x);
    public void Delete(T x);
    public List<T> Listar();
   
}
