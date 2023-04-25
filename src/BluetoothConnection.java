import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.bluetooth.BluetoothDevice;
import javax.bluetooth.BluetoothSocket;
import javax.microedition.io.Connector;

public class BluetoothConnection {
    
    private BluetoothSocket socket;
    private OutputStream outputStream;
    
    public BluetoothConnection(String address) {
        try {
            // Cria um objeto BluetoothDevice com base no endereço MAC do módulo HC-05
            BluetoothDevice device = javax.bluetooth.LocalDevice.getLocalDevice().getDiscoveryAgent().getRemoteDevice(address);
            // Cria uma string URL no formato correto para se conectar ao módulo HC-05
            String url = "btspp://" + device.getBluetoothAddress() + ":1;authenticate=false;encrypt=false;master=false";
            // Cria um objeto BluetoothSocket a partir da string URL
            socket = (BluetoothSocket) Connector.open(url);
            // Cria um objeto OutputStream para enviar dados para o módulo HC-05
            outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendChar(char c) {
        try {
            // Converte o caractere em um array de bytes e envia pelo OutputStream
            byte[] bytes = new byte[] { (byte) c };
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            // Fecha o socket e o OutputStream
            socket.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}