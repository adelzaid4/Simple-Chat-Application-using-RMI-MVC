
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

class Model extends UnicastRemoteObject implements ChatClientInterface {

    Controller c;

 
    public Model(Controller c) throws RemoteException{
        this.c = c;
    }

    public void receive(String msg) {
        try {
            c.displayMsg(msg);
        } catch (RemoteException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
