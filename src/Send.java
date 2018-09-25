import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Send {

	public static void main(String[] args) throws Exception {
		String path="/Volumes/Elements/AISdata/nanjin/part-00000";
		//只是测试一下
		FileInputStream fis=new FileInputStream(path);
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		BufferedReader br=new BufferedReader(isr);
		String line="";
		while((line=br.readLine())!=null) {
			Thread.sleep(1000);
			DatagramSocket socket=new DatagramSocket();
			byte[] buf=line.getBytes();
			System.out.println(line);
			//将数据打包
			DatagramPacket packet=new DatagramPacket(buf, buf.length,InetAddress.getByName("10.138.97.15"),8083);
			socket.send(packet);
			socket.close();
		}
		br.close();
		isr.close();
		fis.close();
		
//		Integer i=0;
//		String mm="liufukai";
//		while(true) {
//			Thread.sleep(1000);
//			i=i+1;
//			String mm2=mm+i.toString();
//			DatagramSocket socket=new DatagramSocket();
//			byte[] buf=mm2.getBytes();
//			System.out.println("发送数据了"+mm2);
//			//将数据打包
//			DatagramPacket packet=new DatagramPacket(buf, buf.length,InetAddress.getByName("10.138.97.15"),8080);
//			//DatagramPacket packet=new DatagramPacket(buf, buf.length,InetAddress.getByName("10.138.109.193"),8080);
//			socket.send(packet);
//			socket.close();
//		}
	}
	/**
     * 读取一个文本 一行一行读取
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readFile02(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (line.lastIndexOf("---") < 0) {
                list.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }
}
