package testRSA;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;



public class ToInterface {
	

	/*public static final String GET_URL = "http://cqdev.paxpay.cn:8180/cms/gateway.do";*/
	public static final String GET_URL = "https://cqdev.paxpay.cn:8443/cmswx/gateway.do";

	public static void httpURLConnectionPOST() {
		try {
			URL url = new URL(GET_URL);
			// 将url 以 open方法返回的urlConnection 连接强转为HttpURLConnection连接
			// (标识一个url所引用的远程对象连接)
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中

			// 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
			connection.setDoOutput(true);

			// 设置连接输入流为true
			connection.setDoInput(true);

			// 设置请求方式为post
			connection.setRequestMethod("POST");

			// post请求缓存设为false
			connection.setUseCaches(false);

			// 设置该HttpURLConnection实例是否自动执行重定向
			connection.setInstanceFollowRedirects(true);

			// 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
			// application/x-javascript text/xml->xml数据
			// application/x-javascript->json对象
			// application/x-www-form-urlencoded->表单数据
			// ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			// 建立连接
			// (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
			connection.connect();
			String qm = "";
			// 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
			DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
			Parms t = new Parms();
			String content="/9j/4AAQSkZJRgABAQEASABIAAD/2wBDABALCwwMDBENDREYEA4QGBwVEREVHCEZGRkZGSEgGRwcHBwZICAlJygnJSAwMDQ0MDBAQEBAQEBAQEBAQEBAQED/2wBDAREQEBITEhYSEhYWEhUSFhwWFxcWHCgcHB0cHCgxJSAgICAlMSwvKCgoLyw2NjExNjZAQD9AQEBAQEBAQEBAQED/wAARCAAUACwDAREAAhEBAxEB/8QAGgAAAgMBAQAAAAAAAAAAAAAAAwUAAQIEBv/EACwQAAEDAwIEBQQDAAAAAAAAAAECAwQAESEFEhMiMVEUIzIzYRUkQUNygrH/xAAUAQEAAAAAAAAAAAAAAAAAAAAA/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8A9hqGoeGKGWkcWU77bY/1XxQK16pKEnwjCTO1EZcQk7I7H81UHY1K1BpAflOsuJLqWi22gpF1KCORZUb2J7UDeglBKBLsVw5D4cSiS+soW6T7LYxbPxQAQ4y2wY2m2ZhozJnLwD3IJ9RNAOEv6g+1KILGjwT9tvwX3fTxCOwvj5oH/i4/NzgbBuVfFh3zQUJkZQSoOCzhsg9yKDTchp0bmzvT0uAbUA3oUR5e91lC19yKALmnR5K/PBW22eRn9Y/qKCtQSC5EY6NqcyBj0jFBkRW3prqVE+VsKc3JJv13XoOCOnjoZhrPkq4i1W6kgm2aBrpTinIaCr8XT2wDag//2Q==";
			//String content = Base64Util.getImageStr("C:\\Users\\admin\\Desktop\\2183f45f828f835679b94ee2d33de38d.jpg");// 图片路径
			//System.out.println("zhuanma" + content);
			//111content=Util.getDecodeText(content, true);
			t.setImage_content(content);
			//System.out.println(t);
			String parms = Util.generateSignContent(t, false, "sign");//111
			qm = Util.sign(parms, "D:\\privatekey.txt", "utf-8");
			 qm=Util.getDecodeText(qm, true);
			 System.out.println("qm="+qm);
			 qm=Util.getDecodeText(qm, true);
//			// qm=URLEncoder.encode(qm, "utf-8");
//			 
//			//qm = URLEncoder.encode(qm, "utf-8");
//			/*String sign = "&sign=" + qm.replace("%2F", "");*/
//			String sign = "&sign=" + qm;
//			//parms = Util.generateSignContent(t, false, "sign");
//			//parms=Util.getDecodeText(parms, true);
//			/*String parm = parms + sign;*/
//			Paramses p=new Paramses();
//			parms=Util.generateSignContent(p, true, "sign");
//			content=Util.getDecodeText(content, true);
//			content=Util.getDecodeText(content, true);
//			String image_content = "&image_content=" + content;
//			String parm = parms+sign+image_content;
//			//parm=Util.getDecodeText(parm, true);
//		/*	String urlss = "http://cqdev.paxpay.cn:8180/cms/gateway.do";
//			Test11.sendPost(urlss, parm);*/
//			//System.out.println(parm);
//
//	/*		Map<String, String> map = ObjAnalysisUtil.ConvertObjToMap(p);
//			map.put("sign", sign);
//			map.put("image_content", content);
//			HttpClient httpClient = new HttpClient(GET_URL, 3000, 3000);
//			int resultCode = httpClient.send(map, "UTF-8");
//			System.out.println(resultCode);
//			String resultStr = httpClient.getResult();
//			System.out.println(resultStr);*/
//			// 将参数输出到连接 h
//			dataout.writeBytes(parm);
//			// 输出完成后刷新并关闭流
//			//dataout.flush();
//			//dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
//			//System.out.println(connection.getResponseCode());
//			//System.out.println(connection.getResponseMessage());
//
//			//连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
//			BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//			String line;
//			StringBuilder sb = new StringBuilder(); // 用来存储响应数据
//
//			// 循环读取流,若不到结尾处
//			while ((line = bf.readLine()) != null) {
//				// sb.append(bf.readLine());
//				sb.append(line).append(System.getProperty("line.separator"));
//			}
//			bf.close(); // 重要且易忽略步骤 (关闭流,切记!)
//			connection.disconnect(); // 销毁连接
//			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		httpURLConnectionPOST();
	}
}
