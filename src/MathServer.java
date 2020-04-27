import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

public class MathServer extends UnicastRemoteObject implements MathService {

	private int clientCount = 0;
	
	public MathServer() throws RemoteException {
		super();	
	}
	
	
	public synchronized int clientCount() throws RemoteException {
		clientCount++;
		return clientCount;
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		System.out.println("Adding " + a + " and " + b + " in the Server");
        return a+b;
	}

	@Override
	public int subtract(int a, int b) throws RemoteException {
		System.out.println("subtracting " + a + " and " + b + " in the Server");
        return a-b;
	}

	@Override
	public int multiply(int a, int b) throws RemoteException {
		System.out.println("multiplying " + a + " and " + b + " in the Server");
        return a*b;
	}
	
	// this method is not remotely accessible as it's not in the remote interface
    public int test(int a){
      System.out.println("this is a test");
      return 0;
    }

	@Override
	public int divide(int a, int b) throws RemoteException {
		System.out.println("dividing " + a + " and " + b + " in the Server");
        return a/b;
	}
	
	public static void main(String[] args) {
		
        try{

   		 	MathServer svr = new MathServer();
		 // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CalculatorService", svr);

            System.out.println ("Service started....");
            
        }
        catch(RemoteException re){
            System.err.println(re.getMessage());
        }
        catch(AlreadyBoundException abe){
            System.err.println(abe.getMessage());
        }
	}


	

}
