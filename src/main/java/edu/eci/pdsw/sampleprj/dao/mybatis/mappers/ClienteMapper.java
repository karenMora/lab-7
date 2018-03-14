package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(int id, 
            int idit, 
            Date fechainicio,
            Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public Cliente consultarCliente(@Param("id")int id); 
    public Cliente getCliente(@Param("id") long id);
    public void insertarCliente(@Param ("cliente")Cliente c);
    public void agregarItemrentadoACliente(@Param("id")int i,@Param("documento")int i0, @Param("idi")int i1, @Param("fechainic")Date fechai,@Param("fechafinal") Date fechaf);

}
