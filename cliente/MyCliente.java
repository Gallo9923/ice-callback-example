package cliente;

import Pruebita.ServidorPrx;

public class MyCliente {


    public static void main(String[] args){
        
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client"))
        {
            
            Pruebita.ServidorPrx serverPrx = ServidorPrx.checkedCast(
            communicator.propertyToProxy("Servidor.Proxy")).ice_twoway().ice_timeout(-1).ice_secure(false);
            if(serverPrx == null)
            {
                System.err.println("invalid proxy");
                return 1;
            }

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Cliente.Servidor");
            adapter.add(new ClientI(), com.zeroc.Ice.Util.stringToIdentity("cliente"));
            adapter.activate();
            
            ClientePrx clientePrx = ClientePrx.uncheckedCast(adapter.createProxy(
            com.zeroc.Ice.Util.stringToIdentity("cliente")));


            serverPrx.sendMsg(clientePrx, "Hola");
            
        }

    }

}