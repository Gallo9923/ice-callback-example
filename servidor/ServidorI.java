import com.zeroc.Ice.Current;


public class ServidorI implements Pruebita.Servidor {

    @Override
    public void sendMsg(Pruebita.ClientePrx proxy, String msg, Current current) {
        proxy.callback(msg);
        
    }
    
}
