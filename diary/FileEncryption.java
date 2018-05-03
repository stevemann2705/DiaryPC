package diary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class FileEncryption {
	static Cipher cipher = null;
	SecretKey desKey;

	public FileEncryption() {
		try {
			DESKeySpec dks = new DESKeySpec(Diary.userKey.getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			this.desKey = skf.generateSecret(dks);
			cipher = Cipher.getInstance("DES");
			System.out.println(this.desKey);
		} catch (NoSuchPaddingException ex) {
			System.out.println(ex);
		} catch (NoSuchAlgorithmException ex) {
			System.out.println(ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeySpecException ex) {
			Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void encrypt(String srcPath, String destPath) {
		File rawFile = new File(srcPath);
		File encryptedFile = new File(destPath);
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			cipher.init(1, this.desKey);

			inStream = new FileInputStream(rawFile);
			outStream = new FileOutputStream(encryptedFile);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inStream.read(buffer)) > 0) {
				outStream.write(cipher.update(buffer, 0, len));
				outStream.flush();
			}
			outStream.write(cipher.doFinal());
			inStream.close();
			outStream.close();
		} catch (IllegalBlockSizeException ex) {
			System.out.println(ex);
		} catch (BadPaddingException ex) {
			System.out.println(ex);
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	protected void decrypt(String srcPath, String destPath) {
		File encryptedFile = new File(srcPath);
		File decryptedFile = new File(destPath);
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			cipher.init(2, this.desKey);

			inStream = new FileInputStream(encryptedFile);
			outStream = new FileOutputStream(decryptedFile);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inStream.read(buffer)) > 0) {
				outStream.write(cipher.update(buffer, 0, len));
				outStream.flush();
			}
			outStream.write(cipher.doFinal());
			inStream.close();
			outStream.close();
		} catch (IllegalBlockSizeException ex) {
			System.out.println(ex);
		} catch (InvalidKeyException ex) {
			System.out.println(ex);
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
