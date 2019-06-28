package testRSA;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parms {
	/*private String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());*/
	private String timestamp="2018-09-03 09:01:55";
	private String partner_id="88888960";
	private String method="paxpay.material.image.upload";
	@Override
	public String toString() {
		return "Parms [timestamp=" + timestamp + ", partner_id=" + partner_id + ", method=" + method + ", sign_type="
				+ sign_type + ", hash_type=" + hash_type + ", version=" + version + ", image_type=" + image_type
				+ ", image_name=" + image_name + ", image_content=" + image_content + "]";
	}

	private String sign_type="RSA";
	private String hash_type="SHA256";
	private String version="1.0";
	private String image_type="jpg";
	private String image_name="txc";
    private String image_content;
    private String format="JSON";
    private String charset="utf-8";
	public String getImage_content() {
		return image_content;
	}

	public void setImage_content(String image_content) {
		this.image_content = image_content;
	}

	public Parms(String timestamp, String partner_id, String method, String sign_type, String hash_type, String version,
			String image_type, String image_name, String image_content) {
		super();
		this.timestamp = timestamp;
		this.partner_id = partner_id;
		this.method = method;
		this.sign_type = sign_type;
		this.hash_type = hash_type;
		this.version = version;
		this.image_type = image_type;
		this.image_name = image_name;
		this.image_content = image_content;
	}

	public Parms() {
		super();
	}
    
}
