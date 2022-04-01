package cliente;

import com.zeroc.Ice.Current;

import Pruebita.Cliente;

public class ClienteI implements Cliente{

    @Override
    public void callback(String msg, Current current) {
        
        System.out.println(msg);
        
    }
    
}
