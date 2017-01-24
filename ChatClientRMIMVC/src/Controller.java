
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

class Controller {

    Model m;
    View vi;
    ChatServerInterface server;

    public Controller() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry(5050);
            server = (ChatServerInterface) reg.lookup("MVCChat");

            m = new Model(this);
            vi = new View(this);
            vi.show();
            server.register(m);
        } catch (NotBoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws RemoteException {
        new Controller();
    }

    public void displayMsg(String msg) throws RemoteException {
        vi.display(msg);

    }

    public void tellOthers(String text) throws RemoteException {
        server.tellOthers(text);
    }

    public void unRegister() throws RemoteException {
        server.unRegister(m);
    }

    
}
