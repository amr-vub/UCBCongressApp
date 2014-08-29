package org.ucb.service.documents;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartException;
import org.ucb.data.dao.IDocumentManager;
import org.ucb.data.dao.ISessionManager;
import org.ucb.data.domain.Docs;
import org.ucb.data.domain.Session;
import org.ucb.service.model.Document;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

public class DocumentService implements IDocumentService {

	@Autowired
	private IDocumentManager documentManager;
	
	@Autowired
	private ISessionManager sessionManager;

	@SuppressWarnings({ "deprecation", "resource" })
	@Transactional
	public int uploadDocument(Document modelDoc) {

		Session currentSession;
		List<Docs> sessionDocs;
		
		Docs dataDoc = documentManager.getDocumentByID(modelDoc
				.getDocumentID());		
		
		currentSession = sessionManager.getSessionById(dataDoc.getDocID());

		if (null != currentSession) {		

			HttpResponse response;
			HttpClient httpclient = new DefaultHttpClient();
			httpclient.getParams().setParameter(
					CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

			HttpPost httppost = new HttpPost(dataDoc.getDocLink());
			File file = new File(modelDoc.getPath());

			FileEntity reqEntity = new FileEntity(file, "binary/octet-stream");

			httppost.setEntity(reqEntity);
			reqEntity.setContentType("binary/octet-stream");

			try {
				response = httpclient.execute(httppost);

				HttpEntity resEntity = response.getEntity();

				if (resEntity != null) {
					resEntity.consumeContent();
				}
				return 0;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			httpclient.getConnectionManager().shutdown();
			
			sessionDocs = currentSession.getSession_docs();
			
			// Add the document to session's list of documents
			sessionDocs.add(dataDoc);
			
			currentSession.setSession_docs(sessionDocs);
			
			// Update the DB
			documentManager.storeDocument(dataDoc);
			sessionManager.updateSession(currentSession);
		}
		return -1;

	}

	private static void download(String address, String localFileName) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;

		try {
			URL url = new URL(address);
			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];

			int numRead;

			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
		}
	}

	/**
	 * Downloads a document.
	 * @return 0 - the download was successful
	 * @return -1 - the download failed
	 */
	@Transactional
	public int downloadDocument(Document modelDoc) {

		Docs dataDoc = documentManager.getDocumentByID(modelDoc
				.getDocumentID());

		if (null != dataDoc) {

			String url = dataDoc.getDocLink();

			int lastSlashIndex = url.lastIndexOf('/');
			if (lastSlashIndex >= 0 && lastSlashIndex < url.length() - 1) {
				download(url, url.substring(lastSlashIndex + 1));
				return 0;
			} else {
				return -1;
			}
		}
		return -1;
	}

	@Transactional
	public void setAbstract(Document modelDoc) {
		
		Session currentSession;
		List<Docs> sessionDocs;
		int index = 0;
		Docs dataDoc = documentManager.getDocumentByID(modelDoc
				.getDocumentID());
		
		currentSession = sessionManager.getSessionById(dataDoc.getDocID());
		
		if(null != dataDoc)
		{
			
			
			// Add the document to session's list of documents
			sessionDocs = currentSession.getSession_docs();
			
			if(!sessionDocs.contains(dataDoc))
			{
				dataDoc.setDocAbstract(modelDoc.get_abstract());
				sessionDocs.add(dataDoc);
			}
			else
			{
				index = sessionDocs.indexOf(dataDoc);				
				dataDoc.setDocAbstract(modelDoc.get_abstract());
				sessionDocs.set(index, dataDoc);
			}
			
			currentSession.setSession_docs(sessionDocs);
			
			// Update the DB
			documentManager.storeDocument(dataDoc);
			sessionManager.updateSession(currentSession);
		}
		
		
	}

	@Transactional
	public String getAbstract(Document modelDoc) 
	{
		Docs dataDoc = documentManager.getDocumentByID(modelDoc
				.getDocumentID());
		
		if(null != dataDoc)
		{
			return dataDoc.getDocAbstract();
		}
		
		return null;
	}


}
