/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author NAVANE
 */
public interface ObjectDAO <T>{
    
    public T Create(ResultSet rss);
    public T Read();
    public void Update(T x);
    public void Delete(T x);
    public List<T> Listar();
    public void Create();
   
    
    
}
