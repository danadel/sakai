/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/sam/branches/samigo-2.8.x/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/servlet/delivery/UploadAudioMediaServlet.java $
 * UploadAudioMediaServlet.java Samoo S.L. modifications
 ***********************************************************************************
 *
 * Copyright (c) 2006, 2008, 2009 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.assignment.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.cover.ServerConfigurationService;

/**
 * <p>
 * Title: Assignment
 * </p>
 * <p>
 * Description: Sakai Assignment Manager. Upload audio recording to the assignment submission.
 * This servlet gets a posted input stream (from AudioRecorder.java in the client JVM)
 * and writes out to a file into a sakai temporary directory.
 * </p>
 */

public class UploadAudioMediaServlet extends HttpServlet {
	private static final long serialVersionUID = 8389831837152012411L;
	private static Log log = LogFactory.getLog(UploadAudioMediaServlet.class);
	
	/**
	 * Max kilobytes upload
	 */
	private static int UPLOAD_MAX_SIZE = ServerConfigurationService.getInt(
			"assignment.sizeMax", 20480);

	public UploadAudioMediaServlet() {
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		boolean mediaIsValid = true;
		ServletContext context = super.getServletContext();
		String repositoryPath = ServerConfigurationService.getString(
				"assignment.answerUploadRepositoryPath",
				"assignment/answerUploadRepositoryPath/");

		log.debug("****req content length =" + req.getContentLength());
		log.debug("****req content type =" + req.getContentType());

		// Samoo S.L. we get media location in
		// sakai-assignment-tool/upload_tmp/assignment_XXX/agent_XXX/audio.au
		// form
		String suffix = req.getParameter("suffix");
		if (suffix == null || ("").equals(suffix))
			suffix = "au";
		String mediaLocation = req.getParameter("media") + "." + suffix;
		log.debug("****req media location=" + mediaLocation);
		String response = "empty";

		// test for nonemptiness first
		if (mediaLocation != null && !(mediaLocation.trim()).equals("")) {
			mediaLocation = repositoryPath + "/" + mediaLocation;
			log.debug("****req media location on sakai server=" + mediaLocation);
			File mediaFile = new File(mediaLocation);
			File mediaDir = mediaFile.getParentFile();
			if (!mediaDir.exists())
				mediaDir.mkdirs();
			
			//write to a file the audio received
			mediaIsValid = writeToFile(req, mediaLocation);
		}

		// compose the server response
		if (mediaIsValid) {
			// note that the assignment submission bean is empty. The audio file
			// is in a temporary folder of the Sakai server.
			// the user has to confirm the submission in order to attach the
			// audio file to the assignment submission.
			response = "ok";
		} else {
			response = "error";
		}
		res.setContentType("text/plain");
		res.setContentLength(response.length());
		PrintWriter out = res.getWriter();
		out.println(response);
		out.close();
		out.flush();
	}

	private boolean writeToFile(HttpServletRequest req, String mediaLocation) {
		// default status message, if things go wrong
		boolean mediaIsValid = false;
		String status = "Upload failure: empty media location.";
		ServletInputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedInputStream bufInputStream = null;
		BufferedOutputStream bufOutputStream = null;
		byte[] buffer = new byte[2048];
		int count = 0;

		try {
			inputStream = req.getInputStream();
			fileOutputStream = getFileOutputStream(mediaLocation);

			// buffered input for servlet
			bufInputStream = new BufferedInputStream(inputStream);
			// buffered output to file
			bufOutputStream = new BufferedOutputStream(fileOutputStream);

			// write the binary data
			int amountRead = 0;
			count = 0;
			if (bufInputStream != null) {
				while ((amountRead = bufInputStream.read(buffer)) != -1 && (count/1024) < UPLOAD_MAX_SIZE) {
					bufOutputStream.write(buffer, 0, amountRead);
					count += amountRead;
				}
			}
			bufOutputStream.flush();

			status = "Acknowleged: " + mediaLocation + "-> " + count
					+ " bytes.";
			if (count > 0)
				mediaIsValid = true;
		} catch (Exception ex) {
			log.info(ex.getMessage());
			status = "Upload failure: " + mediaLocation;
		} finally {
			if (bufOutputStream != null) {
				try {
					bufOutputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
			if (bufInputStream != null) {
				try {
					bufInputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		}
		log.info(status);
		return mediaIsValid;
	}	

	private FileOutputStream getFileOutputStream(String mediaLocation) {
		FileOutputStream outputStream = null;
		try {
			File media = new File(mediaLocation);
			outputStream = new FileOutputStream(media);
		} catch (FileNotFoundException ex) {
			log.warn("file not found=" + ex.getMessage());
		}
		return outputStream;
	}

}
