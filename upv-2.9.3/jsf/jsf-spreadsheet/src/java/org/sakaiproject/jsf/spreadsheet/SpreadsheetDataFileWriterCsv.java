/**********************************************************************************
*
* $Id: SpreadsheetDataFileWriterCsv.java 316136 2014-12-18 16:55:15Z anueda@asic.upv.es $
*
***********************************************************************************
*
 * Copyright (c) 2007, 2008 The Sakai Foundation
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

package org.sakaiproject.jsf.spreadsheet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.cover.ServerConfigurationService;
import org.sakaiproject.util.ResourceLoader;

/**
 * NOTE: CSV export capabilities are extremely limited! UTF-16 text (such as
 * Chinese) is not supported correctly, for example. Use Excel-formatted output if at all
 * possible.
 */
public class SpreadsheetDataFileWriterCsv implements SpreadsheetDataFileWriter {
	private static final Log log = LogFactory.getLog(SpreadsheetDataFileWriterCsv.class);

	public void writeDataToResponse(List<List<Object>> spreadsheetData, String fileName, HttpServletResponse response) {
		response.setContentType("text/comma-separated-values");
		SpreadsheetUtil.setEscapedAttachmentHeader(response, fileName + ".csv");

		String csvString = getAsCsv(spreadsheetData);
		OutputStream out = null;
		try {
			byte[] csvArray = csvString.getBytes("UTF-8");
			response.setContentLength(csvArray.length);
			out = response.getOutputStream();
			out.write(csvArray);
			out.flush();
		} catch (Exception e) {
			if (log.isErrorEnabled()) log.error(e);
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) {
				if (log.isErrorEnabled()) log.error(e);
			}
		}
	}

	private String getAsCsv(List<List<Object>> spreadsheetData) {
		String csvSep = ServerConfigurationService.getString("csv.separator",",");
		StringBuilder sb = new StringBuilder();

		// make sure the numeric display is locale-aware
		NumberFormat nf = NumberFormat.getInstance(new ResourceLoader().getLocale());

		for (List<Object> rowData : spreadsheetData) {
			Iterator<Object> dataIter = rowData.iterator();
			while (dataIter.hasNext()) {
				Object data = dataIter.next();
				if (data != null) {
					if (data instanceof String) {
						appendQuoted(sb, (String)data);
					} else if (data instanceof Double) {
						if ((nf.format(data)).indexOf(",") > 0 && csvSep.equals(","))
							appendQuoted(sb, nf.format(data));
						else 
							sb.append(nf.format(data));
					} else {
						sb.append(data);
					}
				}
				if (dataIter.hasNext()) {
					sb.append(csvSep);
				} else {
					sb.append("\n");
				}
			}
		}

		return sb.toString();
	}

	private StringBuilder appendQuoted(StringBuilder sb, String toQuote) {
		if ((toQuote.indexOf(',') >= 0) || (toQuote.indexOf('"') >= 0)) {
			String out = toQuote.replaceAll("\"", "\"\"");
			if(log.isDebugEnabled()) log.debug("Turning '" + toQuote + "' to '" + out + "'");
			sb.append("\"").append(out).append("\"");
		} else {
			sb.append(toQuote);
		}
		return sb;
	}

}
