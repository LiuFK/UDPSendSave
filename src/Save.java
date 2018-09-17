import java.awt.Button;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Save {

	public static void main(String[] args) throws IOException {
		//定义一个接收端，并且指定了接收的端口号
		DatagramSocket socket=new DatagramSocket(8080);
		
		while(true) {
			byte[] buf=new byte[1024];
			//解析数据包
			DatagramPacket packet=new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String ip=packet.getAddress().getHostAddress();
			buf=packet.getData();
			String data=new String(buf,0, packet.getLength());
			System.out.println("收到"+ip+"发送来的消息"+data);
		}
		
		//System.out.println(InetAddress.getLocalHost().toString());
	}

}
