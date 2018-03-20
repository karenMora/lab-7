package edu.eci.pdsw.test;

import java.util.List;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

/**
 *
 * @author fchaves
 */

public class ServiciosAlquilerTest {
    @Inject
    private SqlSession sqlSession;
    //gdfgdfg

    ServiciosAlquiler serviciosAlquiler;
    Cliente cl=new Cliente("pedro", 123457,"356788", "calle 180 bis", "prdro.p@hotmail.com");
    Cliente p=new Cliente("andrea", 745782,"2456", "calle 80", "andrea@hotmail.com");
    TipoItem tipItm=new TipoItem(1, "fgtyuj");
    Item itm=new Item(tipItm,1, "papas", "papa criolla", java.sql.Date.valueOf("2018-03-15"), 300, "65uu", "verdura");
    Item itmNew=new Item(tipItm,2, "pollo", "pollo asado", java.sql.Date.valueOf("2017-12-20"),5000, "we", "carnes");

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        qt().forAll(integers().allPositive()).check((id) -> {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(id);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
             return r;
        });
    }
    
    
    @Test
    public void deberiaConsultarCliente() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.consultarCliente(123457);
        assertTrue();
    }
    
    
    @Test
    public void deberiaConsultarMulta() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.consultarMultaAlquiler(12,java.sql.Date.valueOf("2016-03-05") );
    }
    
    @Test
    public void deberiaDecirSiEsItem() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.consultarTipoItem(1);
    }
    
    @Test
    public void deberiaRegistrarAlquilerCliente(){
        serviciosAlquiler.registrarAlquilerCliente(java.sql.Date.valueOf("2016-03-05"), 745782, itm, 3);
    }
    
    @Test
    public void deberiaRegistrarCliente() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.registrarCliente(p);
    }
    
    @Test
    public void deberiaRegistrarItem() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.registrarItem(itmNew);
    }
    
    @Test
    public void deberiaConocerElValorDeLaMulta(){
        serviciosAlquiler.valorMultaRetrasoxDia(2);
    }
    
    @Test
    public void deberiaVetarUnCliente() throws ExcepcionServiciosAlquiler{
        serviciosAlquiler.vetarCliente(745782, true);
    }
}

