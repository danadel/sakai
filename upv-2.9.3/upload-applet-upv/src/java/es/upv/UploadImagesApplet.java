package es.upv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UploadImagesApplet extends java.applet.Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8453602971052341194L;

	
	// Constructs the applet
	public UploadImagesApplet() {
		
	}
	
	public static void main(String[] args) {
		
		UploadImagesApplet applet = new UploadImagesApplet();
		applet.init();
	}
	
	public void init() {
		        
        setVisible(false);
	}
	
	public String findLocalImagesEmbeddedInEditor(String contentEditor)
    {
		contentEditor = unEscapeHtml(contentEditor);
		String checkforimgs = contentEditor;
		
		String servletUrl = getParameter("serverUrl") + "pastefromword/uploadimages/";
		
		String fileName;
		int startSrc =0;
		int endSrc = 0;
		// look for local embedded images
		try
		{
			while(checkforimgs !=null)
			{
				// look for a href and img tag
	        	ArrayList embedData = findEmbedItemPattern(checkforimgs);
	        	
    			checkforimgs = (String)embedData.get(0);
    			if (embedData.size() > 1)
    			{
    				startSrc = ((Integer)embedData.get(1)).intValue();
    				endSrc = ((Integer)embedData.get(2)).intValue();
    			}
    			if (endSrc <= 0) break;
    			// find filename
    			fileName = checkforimgs.substring(startSrc, endSrc);
    			
    			String patternStr = fileName;
    			//process for local uploaded files
				if(fileName != null && fileName.trim().length() > 0&& (!(fileName.equals(File.separator)))
					&& fileName.startsWith("file:/") )
				{
					// word paste fix
					patternStr = replace(patternStr, "\\", "/");
					contentEditor = replace(contentEditor, fileName, patternStr);
					checkforimgs =  replace(checkforimgs, fileName, patternStr);

					fileName = patternStr;
	  	  	    	
	  	  	    	// add the file to collection and move from uploads directory
	  	  	    	// read data
	  	  	    	try {
	  	  	    		final File re = new File(new URI(fileName));
	  	  	    		
	  	  	    		byte[] data = AccessController.doPrivileged(
	  	  	    				new PrivilegedAction<byte[]>() {
	  	  	    					public byte[] run() {
	  	  	    						return new byte[(int)re.length()];
	  	  	    					}
	  	  	    				});
	  	  	    		
	  	  	    		FileInputStream fis = AccessController.doPrivileged(
	  	  	    				new PrivilegedExceptionAction<FileInputStream>() {
	  	  	    					public FileInputStream run() throws FileNotFoundException {
	  	  	    						return new FileInputStream(re);
	  	  	    					}
	  	  	    				});
	  	  	    		
	  	  	    		fis.read(data);
	  	  	    		fis.close();
	  	  	    		
	  	  	    		// add as a resource to uploads collection
	  	  	    		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
	  	  	    		
	  	  	    		try
	  	  	    		{
	  	  	    			fileName = URLDecoder.decode(fileName, "UTF-8");
	  	  	    		}
	  	  	    		catch(Exception e){
	  	  	    			e.printStackTrace();
	  	  	    		}
	  	  	    		
		  	  	    	try {
		  		        	URL url = new URL(servletUrl);
		  					HttpURLConnection con = (HttpURLConnection)url.openConnection();
		  					con.addRequestProperty("name", fileName);
		  					con.setRequestMethod("POST");
		  					con.setRequestProperty("CONTENT-TYPE", getMimeType(fileName));
		  					
		  					con.setUseCaches(false);
		  					con.setDoOutput(true);
		  					con.setDoInput(true);
		  					
		  					OutputStream outputStream = con.getOutputStream();
		  					outputStream.write(data);
		  					outputStream.flush();
		  					outputStream.close();
	
		  					BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
		  					  
		  					StringBuilder responseBuf = new StringBuilder();
		  					String str;
		  					while (null != ((str = input.readLine()))) {
		  						responseBuf.append(str);
		  					}
		  					String response = responseBuf.toString();
		  					
		  					if ("OK".equals(con.getResponseMessage())) {

			  	  	    		// in content editor replace the file found with resource reference url
			  	  	    		String replaceStr = response;
			  	  	    		
			  	  	    		// Replace all occurrences of pattern in input
			  	  	    		Pattern pattern = Pattern.compile(patternStr);

			  	  	    		//Rashmi's change to fix infinite loop on uploading images
			  	  	    		contentEditor = replacePath(contentEditor, patternStr, replaceStr);
			  	  	    		checkforimgs = replacePath(checkforimgs, patternStr, replaceStr);
		  					}
		  					
		  				} catch (MalformedURLException e) {
		  					// TODO Auto-generated catch block
		  					e.printStackTrace();
		  				} catch (IOException e) {
		  					// TODO Auto-generated catch block
		  					e.printStackTrace();
		  				}
	  	  	    		
	  	  	    	}
	  	  	    	catch(FileNotFoundException ff){
	  	  	    		ff.printStackTrace();
	  	  	    	}
				}
			
	            // iterate next
				if(endSrc > 0 && endSrc <= checkforimgs.length())
					checkforimgs =checkforimgs.substring(endSrc);
				else checkforimgs = null;
	            startSrc=0; endSrc = 0;
	         }
		}
        catch(Exception e){
        	e.printStackTrace();
        }
                 
    	return contentEditor;
    }
	
	private ArrayList findEmbedItemPattern(String checkforimgs)
	{
    	ArrayList returnData = new ArrayList();
    	// a and link uses href, applet uses archive, object uses data
    	Pattern p1 = Pattern.compile("<[iI][mM][gG]\\s|<[aA]\\s|<[eE][mM][bB][eE][dD]\\s|<[sS][cC][rR][iI][pP][tT]\\s|<[lL][iI][nN][kK]\\s|<[aA][pP][pP][lL][eE][tT]\\s|<[oO][bB][jJ][eE][cC][tT]\\s|<v:imagedata\\s");
    	Pattern pi = Pattern.compile(">|\\s[sS][rR][cC]\\s*=");
    	Pattern pa = Pattern.compile(">|\\s[hH][rR][eE][fF]\\s*=");
    	Pattern pa1 = Pattern.compile(">|\\s[aA][rR][cC][hH][iI][vV][eE]\\s*=");
    	Pattern pd = Pattern.compile(">|\\s[dD][aA][tT][aA]\\s*=");
		Pattern ps = Pattern.compile("\\S");
		Pattern pe = Pattern.compile("\\s|>");
		 
		int startSrc = 0;
		int endSrc = 0;
		String foundPattern = null;
		while(checkforimgs !=null) {
			foundPattern = null;
			// look for <img or <a
			Matcher m = p1.matcher(checkforimgs);
			if (!m.find()) // found anything?
				break;
			checkforimgs = checkforimgs.substring(m.start());
			// look for src= or href=
			if (checkforimgs.startsWith("<i") ||
					checkforimgs.startsWith("<I") ||
					checkforimgs.startsWith("<e") ||
					checkforimgs.startsWith("<E") ||
					checkforimgs.startsWith("<s") ||
					checkforimgs.startsWith("<S") ||
					checkforimgs.startsWith("<v:"))
				m = pi.matcher(checkforimgs);
			else if (checkforimgs.startsWith("<applet")|| checkforimgs.startsWith("<Applet") ||
					checkforimgs.startsWith("<APPLET"))
				m = pa1.matcher(checkforimgs);
			else if (checkforimgs.startsWith("<o")|| checkforimgs.startsWith("<O"))
				m = pd.matcher(checkforimgs);
			else
				m = pa.matcher(checkforimgs);

			if(m.pattern().pattern().equals(pa.pattern())){
				if(checkforimgs.startsWith("<a") ||
						checkforimgs.startsWith("<A"))foundPattern = "link";}
			// end = start+1 means that we found a >
			// i.e. the attribute we're looking for isn't there
			if (!m.find() || (m.end() == m.start() + 1)) {
				// prevent infinite loop by consuming the <
				checkforimgs = checkforimgs.substring(1);
				continue;
			}

			checkforimgs = checkforimgs.substring(m.end());

			// look for start of arg, a non-whitespace
			m = ps.matcher(checkforimgs);
			if (!m.find()) // found anything?
				break;

			checkforimgs = checkforimgs.substring(m.start());

			startSrc = 0;
			endSrc = 0;

			// handle either quoted or nonquoted arg
			if (checkforimgs.startsWith("\"") ||
					checkforimgs.startsWith("\'")) {
				String quotestr = checkforimgs.substring(0,1);
				startSrc = 1;
				endSrc = checkforimgs.indexOf(quotestr, startSrc);
				break;
			} else {
				startSrc = 0;
				// ends with whitespace or >
				m = pe.matcher(checkforimgs);
				if (!m.find()) // found anything?
					continue;
				endSrc = m.start();
			}
		} //while end

		if(foundPattern != null && foundPattern.equals("link"))
		{
			String anchorStr = checkforimgs.substring(startSrc,endSrc);
			anchorStr = anchorStr.trim();
			if (anchorStr != null && (anchorStr.startsWith("#")|| anchorStr.startsWith("mailto:")))
			{
				checkforimgs = checkforimgs.substring(endSrc);
				if(checkforimgs != null)
				{
					ArrayList r = findEmbedItemPattern(checkforimgs);
					checkforimgs = (String)r.get(0);
					if (r.size() > 1 && ((Integer)r.get(2)).intValue() > 0)
					{
						startSrc = ((Integer)r.get(1)).intValue();
						endSrc = ((Integer)r.get(2)).intValue();
						foundPattern = (String)r.get(3);
					}
					else
					{
						startSrc = 0; endSrc = 0;
					}
				}
			}
		}

		returnData.add(checkforimgs);
		if (endSrc != 0) {returnData.add(new Integer(startSrc)); returnData.add(new Integer(endSrc)); returnData.add(foundPattern);}

		return returnData;
	}
    
    private String replace(String s, String one, String another) {
		// In a string replace one substring with another
		if (s.equals(""))
			return "";
		if ((one == null)||(one.length() == 0))
		{
			return s;
		}
		String res = "";
		int i = s.indexOf(one, 0);
		int lastpos = 0;
		while (i != -1) {
			res += s.substring(lastpos, i) + another;
			lastpos = i + one.length();
			i = s.indexOf(one, lastpos);
		}
		res += s.substring(lastpos); // the rest
		return res;
    }
    
    private String replacePath(String s, String one, String another)
	{
		if (s.equals("")) return "";
		if ((one == null)||(one.length() == 0)) return s;
		String checkOne = "=\""+one+"\"";
		another = "=\""+another+"\"";

		if(s.indexOf(checkOne) != -1)
		{
			s=replace(s,checkOne, another);
			return s;
		}
		checkOne = "='"+one+"'";
		if(s.indexOf(checkOne) != -1)
		{
			s=replace(s,checkOne, another);
			return s;
		}
		checkOne = "="+one;
		if(s.indexOf(checkOne) != -1)
		{
			s=replace(s,checkOne, another);
			return s;
		}

		return s;
	}
    
    private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";
 
    private static final int splitLinesAt = 76;
 
    public static byte[] zeroPad(int length, byte[] bytes) {
        byte[] padded = new byte[length]; // initialized to zero by JVM
        System.arraycopy(bytes, 0, padded, 0, bytes.length);
        return padded;
    }
 
    public static String encode(byte[] stringArray) {
 
        String encoded = "";
        // determine how many padding bytes to add to the output
        int paddingCount = (3 - (stringArray.length % 3)) % 3;
        // add any necessary padding to the input
        stringArray = zeroPad(stringArray.length + paddingCount, stringArray);
        // process 3 bytes at a time, churning out 4 output bytes
        // worry about CRLF insertions later
        for (int i = 0; i < stringArray.length; i += 3) {
            int j = ((stringArray[i] & 0xff) << 16) +
                ((stringArray[i + 1] & 0xff) << 8) + 
                (stringArray[i + 2] & 0xff);
            encoded = encoded + base64code.charAt((j >> 18) & 0x3f) +
                base64code.charAt((j >> 12) & 0x3f) +
                base64code.charAt((j >> 6) & 0x3f) +
                base64code.charAt(j & 0x3f);
        }
        // replace encoded padding nulls with "="
        return splitLines(encoded.substring(0, encoded.length() -
            paddingCount) + "==".substring(0, paddingCount));
 
    }
    public static String splitLines(String string) {
 
        String lines = "";
        for (int i = 0; i < string.length(); i += splitLinesAt) {
 
            lines += string.substring(i, Math.min(string.length(), i + splitLinesAt));
            lines += "\r\n";
 
        }
        return lines;
 
    }
	
    private String getMimeType(String filename) {
    	
    	Map<String,String> mapMimeTypes = new HashMap<String,String>();
    	mapMimeTypes.put("gif", "image/gif");
    	mapMimeTypes.put("jpg", "image/jpeg");
    	mapMimeTypes.put("png", "image/png");
    	mapMimeTypes.put("tiff", "image/tiff");
    	mapMimeTypes.put("bmp", "image/bmp");
    	
    	String ext = filename.substring(filename.indexOf(".")+1);
    	return mapMimeTypes.get(ext);
    }
    
    private String unEscapeHtml(String value)
	{
		if (value == null) return "";
		if (value.equals("")) return "";
		value = value.replaceAll("&lt;", "<");
		value = value.replaceAll("&gt;", ">");
		value = value.replaceAll("&amp;", "&");
		value = value.replaceAll("&quot;", "\"");
		value = value.replaceAll("%5C", "/");
		return value;
	}
}
