package testRSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;



public class Util {

/**
     *
     * @param t 需要排序的对象
     * @param isNeedDecode 是否需要对数据进行urldecode
     * @param exclusives  不用生成的字段名
     * @param <T>
     * @return
     */
public static <T> String generateSignContent(T t, boolean isNeedDecode, String... exclusives) {
        Class<T> clazz = (Class<T>) t.getClass();
        Class superClazz = clazz.getSuperclass();//这个类所代表的类的超类。

        List<Field> childFields = Arrays.asList(clazz.getDeclaredFields());
        List<Field> superFields = Arrays.asList(superClazz.getDeclaredFields());
        List<Field> allFields = new ArrayList<Field>();
        allFields.addAll(childFields);
        allFields.addAll(superFields);

        List<String> fieldNames = new ArrayList<String>();//文件名
        for (int i = 0; i < allFields.size(); i++) {
            fieldNames.add(allFields.get(i).getName());
        }
        Collections.sort(fieldNames);//排序
        List<Field> fields = new ArrayList<Field>();
        for (String fieldName : fieldNames) {
            for (int i = 0; i < allFields.size(); i++) {
                if (fieldName.equals(allFields.get(i).getName())) {
                    fields.add(allFields.get(i));
                    break;
                }
            }
        }
        StringBuilder sbElu = new StringBuilder();
        for (Field f : fields) {
            // 不用生成的字段名
            boolean flag = true;
            for (String exclusive : exclusives) {
                if (StringUtils.equalsIgnoreCase(f.getName().toUpperCase(), exclusive)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                f.setAccessible(true);
                try {
                    if (null != f.get(t) && StringUtils.isNotBlank(String.valueOf(f.get(t)))) {
                        sbElu.append("&").append(f.getName().toLowerCase()).append("=").append(
                                getDecodeText(String.valueOf(f.get(t)), isNeedDecode));//包含的特殊字符、中文做urlencode处理
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }
        // logger.info(sbElu.toString().substring(1) + "=========================生成的 sign字符串");
        return sbElu.toString().substring(1);
    }

/**
     * 对数据进行urldecode
     *
     * @param textToDecode
     * @param isNeed2Decode
     * @return
     */

    public static String getDecodeText(String textToDecode, boolean isNeed2Decode) throws Exception {
        if (isNeed2Decode) {
        	//return URLDecoder.decode(textToDecode, "UTF-8");
        	 return URLEncoder.encode(textToDecode, "UTF-8");
        } else {
            return textToDecode;
        }
    }
// encode的作用是将unicode编码转换成其他编码的字符串
    // decode的作用是将其他编码的字符串转换成unicode编码
/**
     * RSA签名
     * @param content 待签名数据
     * @param privateKey 商户私钥
     * @param encode 字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode)
    {
    	FileReader objFileReader = null;
    	BufferedReader br = null;
        try
        {
        	objFileReader = new FileReader(privateKey);
            br = new BufferedReader(objFileReader);
            String s = br.readLine();
            String str = "";
            s = br.readLine();
            while (s.charAt(0) != '-') {
                str += s;
                s = br.readLine();
            }
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64.decodeBase64(str) );
            System.out.println("privateKey=");
            byte[] bs = Base64.decodeBase64(str);
            for(int n=0;n<bs.length;n++){
            	System.out.print(bs[n]);
            }
            System.out.println("");
            KeyFactory keyf                 = KeyFactory.getInstance("RSA");
            PrivateKey priKey               = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");

            signature.initSign(priKey);
            signature.update( content.getBytes(encode));

            byte[] signed = signature.sign();

            return Base64.encodeBase64String(signed);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            try {
                if (objFileReader != null) {
                	objFileReader.close();
                }
                if (br != null) {
                	br.close();
                }
            } catch (Exception e) {
            	//logger.error("关闭失败");
                //throw new BusinessException("关闭失败");
            }
        }

        return null;
    }


/**
     * RSA验签名检查
     * @param content 待签名数据
     * @param sign 签名值
     * @param publicKey 分配给开发商公钥
     * @param encode 字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey,String encode)
    {
    	FileReader objFileReader = null;//读取字符流对象
    	BufferedReader br = null;
        try
        {
        	ByteBuffer byteBuffer = ByteBuffer.allocate(102400);//字节缓冲区102400字节
        	objFileReader = new FileReader(publicKey.trim());//文件名
            br = new BufferedReader(objFileReader);
            String s = br.readLine();
            String str = "";
            s = br.readLine();
            while (s.charAt(0) != '-') {
                str += s;
                s = br.readLine();
            }//拼接公钥字符
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(str);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature
                    .getInstance("SHA256withRSA");

            signature.initVerify(pubKey);
            signature.update( content.getBytes(encode) );

            boolean bverify = signature.verify( Base64.decodeBase64(sign) );
            return bverify;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
                if (objFileReader != null) {
                	objFileReader.close();
                }
                if (br != null) {
                	br.close();
                }
            } catch (Exception e) {
            /*	logger.error("关闭失败");
                throw new BusinessException("关闭失败");*/
            }
        }
        return false;
    }

}

