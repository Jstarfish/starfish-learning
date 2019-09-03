package com.qihoo.dmp.southernAirlines.observable;

import com.qihoo.dmp.southernAirlines.bo.StandardProductStruct;
import com.qihoo.dmp.southernAirlines.bo.StandardProductStructStorage;
import com.qihoo.dmp.southernAirlines.utils.DateUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Observable;

import static com.qihoo.dmp.southernAirlines.utils.Constants.*;


public abstract class FileParser extends Observable {
	
	StandardProductStructStorage standardProductStructStorage;
	public int size = 1000;
	public String flag;
	public FileParser(String flag) {
		this.flag = flag;
		Runtime.getRuntime().addShutdownHook(new ShutdownHook(flag));
		standardProductStructStorage = new StandardProductStructStorage(flag);
	}
	public FileParser(String flag, int size) {
		this(flag);
		this.size = size;
	}
	protected synchronized void addStandardProductStruct(StandardProductStruct e) {
		standardProductStructStorage.addStandardProductStruct(e);
		if (standardProductStructStorage.size() >= size) {
			System.out.println("standardProductStructStorage.size() >= " + size);
			update();
		}
	}
	protected  SAXReader getSafeSAXReader() {
		SAXReader saxReader = new SAXReader();
		XMLReader xmlReader;
		try {
			xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
			saxReader.setXMLReader(xmlReader);
			saxReader.setEncoding("UTF-8");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saxReader;
	}
	protected InputSource getInputSource(File file) {
		InputSource inputSource = null;
		HttpURLConnection conn = null;
		try {
			InputStream is = new FileInputStream(file);
			inputSource = new InputSource(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(conn);
		}
		return inputSource;
	}
	protected InputSource getInputSource(String url) {
		URL ourl;
		InputSource inputSource = null;
		HttpURLConnection conn = null;
		try {
			ourl = new URL(url);
			conn = (HttpURLConnection) (ourl.openConnection());
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("User-Agent", "360dmp");
			conn.setRequestProperty("Charset", "UTF-8");
			InputStream is = conn.getInputStream();
			inputSource = new InputSource(is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return inputSource;
	}
	public void update() {
		setChanged();
		notifyObservers(standardProductStructStorage);
	}
	public void clearXmlDir() throws IOException {
		String xmlPath = XMLPATH + flag + "/";
		File xmlPathDir = new File(xmlPath);
		if (!xmlPathDir.exists()) {
			xmlPathDir.mkdir();
		} else {
			System.out.println("clear : " + xmlPathDir);
			FileUtils.cleanDirectory(xmlPathDir);
		}
	}
	private class ShutdownHook extends Thread {
		private String flag;
		private String xmlPath;
		private String ftpPath;
		public ShutdownHook (String flag) {
			this.flag = flag;
			xmlPath = XMLPATH + flag + "/";
			ftpPath = FTPPATH + flag + "/";
		}
		@Override
		public void run() {
			System.out.println("ShutdownHook");
			update();
			sitemap(flag);
		}
		private void writeXml(Document document, File file) {
			XMLWriter writer = null;
			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("UTF-8");
				FileOutputStream fos = new FileOutputStream(file);
				writer = new XMLWriter(fos, format);
				writer.write(document);
				writer.close();
			} catch (IOException e) {
				System.out.println(file.getName());
				e.printStackTrace();
			} finally {
				if (writer != null)
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		private void sitemap(String flag) {
			XMLWriter writer = null;
			try {
				File xmlPathDir = new File(xmlPath);
				if (!xmlPathDir.exists()) {
					xmlPathDir.mkdir();
				}
				File dir = new File(xmlPathDir, SUB);
				File[] fileList = dir.listFiles();
				Arrays.sort(fileList, new Comparator<File>() {
					public int compare(File f1, File f2) {
						long diff = f1.lastModified() - f2.lastModified();
						if (diff > 0)
							return 1;
						else if (diff == 0)
							return 0;
						else
							return -1;
					}

					public boolean equals(Object obj) {
						return true;
					}

				});  
				Document document = DocumentHelper.createDocument();
				Element root = document.addElement("sitemapindex");
				for (File file : fileList) {
					Element sitemap = root.addElement("sitemap");
					Element loc = sitemap.addElement("loc");
					loc.addCDATA(HOST + "/" + flag + "/" + SUB + "/" + file.getName());
					Element lastmod = sitemap.addElement("lastmod");
					lastmod.addCDATA(DateUtils.convertDateToString(new Date(file.lastModified()), DateUtils.DateFormat4));
				}
				File file = new File(xmlPathDir, "index.xml");
				writeXml(document, file);
				
				File ftpPathDir = new File(ftpPath);
				if (ftpPathDir.exists()) {
					FileUtils.cleanDirectory(ftpPathDir);
				}
				FileUtils.copyDirectory(xmlPathDir, ftpPathDir);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null)
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
			}
		}
	}
	
	protected abstract void start(String[] args);
}
