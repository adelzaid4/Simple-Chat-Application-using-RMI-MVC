import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ViewInterface extends Remote{
    void display(String msg) throws RemoteException;
}
