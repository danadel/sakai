/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/sam/tags/samigo-2.8.0/samigo-hibernate/src/java/org/sakaiproject/tool/assessment/data/dao/assessment/ItemMetaData.java $
 * $Id: ItemMetaData.java 59684 2009-04-03 23:33:27Z arwhyte@umich.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2008 The Sakai Foundation
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

package org.sakaiproject.tool.assessment.data.dao.assessment;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Category;
import org.sakaiproject.tool.assessment.data.ifc.assessment.ItemHistoricalIfc;
import org.sakaiproject.tool.assessment.data.ifc.assessment.ItemDataIfc;


public class ItemHistorical implements Serializable, Comparable, ItemHistoricalIfc {
  static Category errorLogger = Category.getInstance("errorLogger");

  private static final long serialVersionUID = 7526471155622776147L;

  private Long id;
  private ItemDataIfc item;
  private String modifiedBy;
  private Date modifiedDate;

  public ItemHistorical() {}

  public ItemHistorical(ItemDataIfc item, String modifiedBy, Date modifiedDate) {
    this.item = item;
    this.modifiedBy = modifiedBy;
    this.modifiedDate = modifiedDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ItemDataIfc getItem() {
    return item;
  }

  public void setItem(ItemDataIfc item) {
    this.item = item;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  private void writeObject(java.io.ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
  }

  private void readObject(java.io.ObjectInputStream in) throws IOException,
      ClassNotFoundException {
    in.defaultReadObject();
  }

  public int compareTo(Object o) {
	  
	  if (o != null && o instanceof ItemHistorical) {
		  ItemHistorical hist = (ItemHistorical)o;
		  if (this.modifiedDate != null && hist.modifiedDate != null)
			  return this.modifiedDate.compareTo(hist.modifiedDate);
	  }
	  return 0;
  }
}
