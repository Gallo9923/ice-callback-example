public class MyServidor {

    public static void main(String[] args){

        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.server"))
        {
            
            Runtime.getRuntime().addShutdownHook(new Thread(() -> communicator.destroy()));

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Callback.Server");
            adapter.add(new ServidorI(), com.zeroc.Ice.Util.stringToIdentity("server"));
            adapter.activate();

            communicator.waitForShutdown();
            
        }

        System.exit();
    }

}