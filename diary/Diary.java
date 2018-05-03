/*

Copyright© 2015-2016 Steve Mann

This file is part of Diary.

Diary is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
at your option) any later version.

Diary is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

package diary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Steve Mann
 */
public class Diary {

	/**
	 *
	 * @param key
	 * @param is
	 * @param os
	 * @throws Throwable
	 */
	public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	/**
	 *
	 * @param key
	 * @param is
	 * @param os
	 * @throws Throwable
	 */
	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}

	/**
	 *
	 * @param key
	 * @param mode
	 * @param is
	 * @param os
	 * @throws Throwable
	 */
	public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}

	}

	/**
	 *
	 * @param is
	 * @param os
	 * @throws IOException
	 */
	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

	/**
	 *
	 */
	public static void readFile() {
		try {
			FileReader fr = new FileReader(path + "/" + "settingsTemp.rtf");
			BufferedReader br = new BufferedReader(fr);
			// Scanner scan = new Scanner(new FileReader(path+"\\"+"settingsTemp.txt"));
			try {
				password = br.readLine();

				userKey = br.readLine();

				userName = br.readLine();

			} catch (IOException ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			}

			try {
				br.close();
				fr.close();
			} catch (IOException ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (FileNotFoundException ex) {

		}
		new File(path + "/" + "settingsTemp.rtf").delete();
		new File(path + "/" + "settings2.data").delete();
		new File(path + "/" + "settings1.data").delete();
	}

	public static String password, userKey, userName;
	static String defaultKey = "SteveMann";
	static String path = System.getProperty("user.home") + "/Documents/Diary";
	static File a = new File(path + "/" + "settings.data");

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		if (a.exists()) {
			FileInputStream fis1 = null;
			try {
				fis1 = new FileInputStream(path + "/" + "settings.data");
				FileOutputStream fos1 = new FileOutputStream(path + "/" + "settings2.data");
				decrypt(defaultKey, fis1, fos1);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} catch (Throwable ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fis1.close();
				} catch (IOException ex) {
					Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			try {
				fis1 = new FileInputStream(path + "/" + "settings2.data");
				FileOutputStream fos1 = new FileOutputStream(path + "/" + "settings1.data");
				decrypt(defaultKey, fis1, fos1);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} catch (Throwable ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fis1.close();
				} catch (IOException ex) {
					Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			try {
				fis1 = new FileInputStream(path + "/" + "settings1.data");
				FileOutputStream fos1 = new FileOutputStream(path + "/" + "settingsTemp.rtf");
				decrypt(defaultKey, fis1, fos1);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} catch (Throwable ex) {
				Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fis1.close();
				} catch (IOException ex) {
					Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			readFile();

			Login login = new Login();
			login.setVisible(true);

		} else {
			Setup setup = new Setup();
			setup.setVisible(true);
		}

	}

}
