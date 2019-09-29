/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosWeb;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Juan Carlos
 */
@WebService(serviceName = "ServiciosWeb")
public class ServiciosWeb {


    /**
     * 
     * @param usuario
     * @param password
     * @return 
     */
    @WebMethod(operationName = "buscar")
    public Boolean buscar(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        return usuario.equals("juancarloshdzvqz@gmail.com") && password.equals("Agente007");
    }
}