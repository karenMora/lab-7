/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Cliente;
import java.util.List;

/**
 *
 * @author tatiana
 */
public class MyBATISClienteDao implements ClienteDAO{
    @Inject
    private ClienteMapper clientem;

    @Override
    public void save(Cliente c) throws PersistenceException {
        try{
            clientem.insertarCliente(c);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        try{
            return clientem.consultarCliente(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new UnsupportedOperationException("Not supported yet.");
        } 
    }

    @Override
    public List<Cliente> load() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
