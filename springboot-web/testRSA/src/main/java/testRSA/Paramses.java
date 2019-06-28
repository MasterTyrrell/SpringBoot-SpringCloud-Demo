package testRSA;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paramses {

	private String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String partner_id="88888960";
	private String method="paxpay.material.image.upload";
	@Override
	public String toString() {
		return "Parms [timestamp=" + timestamp + ", partner_id=" + partner_id + ", method=" + method + ", sign_type="
				+ sign_type + ", hash_type=" + hash_type + ", version=" + version + ", image_type=" + image_type
				+ ", image_name=" + image_name +  "]";
	}

	private String sign_type="RSA";
	private String hash_type="SHA256";
	private String version="1.0";
	private String image_type="jpg";
	private String image_name="txc";
    private String format="JSON";
    private String charset="utf-8";
	public Paramses() {
		super();
	}
	

}
