package com.jeecg.api.entity;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class Authentication {
	


	private String key; //商户秘钥
	private String privateKeyStorePassword; //私钥证书密码
	private KeyStore privateKeyStore; //私钥证书
	private X509Certificate certificate; //公钥证书

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getPrivateKeyStorePassword() {
		return privateKeyStorePassword;
	}
	
	public void setPrivateKeyStorePassword(String privateKeyStorePassword) {
		this.privateKeyStorePassword = privateKeyStorePassword;
	}

	public KeyStore getPrivateKeyStore() {
		return privateKeyStore;
	}

	public void setPrivateKeyStore(KeyStore privateKeyStore) {
		this.privateKeyStore = privateKeyStore;
	}

	public X509Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(X509Certificate certificate) {
		this.certificate = certificate;
	}

	/**
	 * 获取私钥证书中的商户私钥
	 * @return
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 */
	public PrivateKey getPrivateKey() throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
		
		Enumeration<String> es = privateKeyStore.aliases() ;
		
		PrivateKey result = null ;
		
		while (es.hasMoreElements()) {
			String alias = es.nextElement();
			result = (PrivateKey) privateKeyStore.getKey(alias, privateKeyStorePassword.toCharArray());
			if (result != null) {
				return result ;
			}
		}
		
		return result ;
	}
	
	/**
	 * add by ky_qbq
	 * 根据别名和密码获取私钥证书中的商户私钥
	 * @return
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 */
	public PrivateKey getPrivateKey(String alias) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
		return (PrivateKey) privateKeyStore.getKey(alias, privateKeyStorePassword.toCharArray());
	}

	/**
	 * 获取私钥证书中的商户公钥证书
	 * @return
	 * @throws KeyStoreException
	 */
	public X509Certificate getMerCertificate() throws KeyStoreException {
		String alias = privateKeyStore.aliases().nextElement();
		return (X509Certificate) privateKeyStore.getCertificate(alias);
	}

	
	public String encrypt(String dataString, String encoding) {
		/** 使用公钥对密码加密 **/
		byte[] data = null;
		try {
			data = encrypt(dataString.getBytes(encoding));
			return new String(Base64.encodeBase64(data), encoding);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * 使用网关公钥对持卡人密码进行加密，并返回byte[]类型
	 * 
	 * @param publicKey
	 * @param plainPin
	 * @return
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] plainPin) {
		try {

			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
			cipher.init(Cipher.ENCRYPT_MODE, this.certificate.getPublicKey());
			int blockSize = cipher.getBlockSize();
			int outputSize = cipher.getOutputSize(plainPin.length);
			int leavedSize = plainPin.length % blockSize;
			int blocksSize = leavedSize != 0 ? plainPin.length / blockSize + 1
					: plainPin.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (plainPin.length - i * blockSize > 0) {
				if (plainPin.length - i * blockSize > blockSize) {
					cipher.doFinal(plainPin, i * blockSize, blockSize, raw, i
							* outputSize);
				} else {
					cipher.doFinal(plainPin, i * blockSize, plainPin.length - i
							* blockSize, raw, i * outputSize);
				}
				i++;
			}
			return raw;

			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
