CREATE TABLE vc_rooms_om (
  room_id VARCHAR(50) NOT NULL,
  site_id VARCHAR(99) NOT NULL,
  start_date BIGINT,
  end_date BIGINT,
  recurrence_type VARCHAR(45),
  recurrence_count INTEGER,
  calendar_event_id VARCHAR(45),
  announcement_id VARCHAR(45),
  notificate_by_email BOOLEAN,
  access_by_site BOOLEAN,
  PRIMARY KEY (room_id)
)
ENGINE = InnoDB;

CREATE TABLE vc_groups_om (
  room_id VARCHAR(50) NOT NULL,
  group_id VARCHAR(99) NOT NULL,
  PRIMARY KEY (room_id, group_id)
)
ENGINE = InnoDB;

CREATE TABLE vc_users_om (
  room_id VARCHAR(50) NOT NULL,
  user_id VARCHAR(99) NOT NULL,
  PRIMARY KEY (room_id, user_id)
)
ENGINE = InnoDB;

CREATE TABLE vc_sec_om (
  value INTEGER NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (value)
)
ENGINE = InnoDB;

alter table vc_rooms_om 
	add index FK_vc_om_s (site_id), 
	add constraint FK_vc_om_s foreign key (site_id) references SAKAI_SITE (SITE_ID) ON DELETE CASCADE ON UPDATE CASCADE;
	
alter table vc_groups_om 
	add index FK_vc_om_g_g (group_id),
	add constraint FK_vc_om_g_g foreign key (group_id) references SAKAI_SITE_GROUP (GROUP_ID) ON DELETE CASCADE ON UPDATE CASCADE;
	
alter table vc_groups_om 
	add index FK_vc_om_g_r (room_id),
	add constraint FK_vc_om_g_r foreign key (room_id) references vc_rooms_om (room_id) ON DELETE CASCADE ON UPDATE CASCADE;
	
alter table vc_users_om 
	add index FK_vc_om_u_u (user_id),
	add constraint FK_vc_om_u_u foreign key (user_id) references SAKAI_USER (USER_ID) ON DELETE CASCADE ON UPDATE CASCADE;
	
alter table vc_users_om 
	add index FK_vc_om_u_r (room_id),
	add constraint FK_vc_om_u_r foreign key (room_id) references vc_rooms_om (room_id) ON DELETE CASCADE ON UPDATE CASCADE;