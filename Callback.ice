
module Pruebita {

    interface Cliente {
        void callback(string msg);
    }

    interface Servidor {
        void sendMsg(Cliente* proxy, string msg);
    }

}