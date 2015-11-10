CREATE TABLE vc_rooms_cnn (
  room_id VARCHAR2(50) NOT NULL,
  site_id VARCHAR2(50) NOT NULL,
  start_date NUMBER,
  end_date NUMBER,
  recurrence_type VARCHAR2(45),
  recurrence_count NUMBER,
  calendar_event_id VARCHAR2(45),
  announcement_id VARCHAR2(45),
  notificate_by_email CHAR(1),
  access_by_site CHAR(1),
  CONSTRAINT PK_vc_cnn_r_ID PRIMARY KEY (room_id),
  CONSTRAINT FK_vc_cnn_s FOREIGN KEY (site_id)
    REFERENCES sakai_site (site_id)
    ON DELETE CASCADE
);

CREATE TABLE vc_groups_cnn (
  room_id VARCHAR2(50) NOT NULL,
  group_id VARCHAR2(50) NOT NULL,
  CONSTRAINT PK_vc_cnn_g_ID PRIMARY KEY (room_id, group_id),
  CONSTRAINT FK_vc_cnn_g_r FOREIGN KEY (room_id)
    REFERENCES vc_rooms_cnn (room_id)
    ON DELETE CASCADE,
  CONSTRAINT FK_vc_cnn_g_g FOREIGN KEY (group_id)
    REFERENCES sakai_site_group (group_id)
    ON DELETE CASCADE
);

CREATE TABLE vc_users_cnn (
  room_id VARCHAR2(50) NOT NULL,
  user_id VARCHAR2(50) NOT NULL,
  CONSTRAINT PK_vc_cnn_u_ID PRIMARY KEY (room_id, user_id),
  CONSTRAINT FK_vc_cnn_u_r FOREIGN KEY (room_id)
    REFERENCES vc_rooms_cnn (room_id)
    ON DELETE CASCADE,
  CONSTRAINT FK_vc_cnn_u_u FOREIGN KEY (user_id)
    REFERENCES sakai_user (user_id)
    ON DELETE CASCADE
);