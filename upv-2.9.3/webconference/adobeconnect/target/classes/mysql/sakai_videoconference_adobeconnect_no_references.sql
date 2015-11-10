CREATE TABLE `vc_rooms_cnn` (
  `room_id` VARCHAR(50) NOT NULL,
  `site_id` VARCHAR(50) NOT NULL,
  `start_date` BIGINT,
  `end_date` BIGINT,
  `recurrence_type` VARCHAR(45),
  `recurrence_count` INTEGER,
  `calendar_event_id` VARCHAR(45),
  `announcement_id` VARCHAR(45),
  `notificate_by_email` BOOLEAN,
  `access_by_site` BOOLEAN,
  PRIMARY KEY (`room_id`)
)
ENGINE = InnoDB;

CREATE TABLE `vc_groups_cnn` (
  `room_id` VARCHAR(50) NOT NULL,
  `group_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`room_id`, `group_id`)
)
ENGINE = InnoDB;

CREATE TABLE `vc_users_cnn` (
  `room_id` VARCHAR(50) NOT NULL,
  `user_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`room_id`, `user_id`)
)
ENGINE = InnoDB;

	
alter table vc_groups_cnn 
	add index FK_vc_cnn_g_r (room_id),
	add constraint FK_vc_cnn_g_r foreign key (room_id) references vc_rooms_cnn (room_id) ON DELETE CASCADE ON UPDATE CASCADE;
	
alter table vc_users_cnn 
	add index FK_vc_cnn_u_r (room_id),
	add constraint FK_vc_cnn_u_r foreign key (room_id) references vc_rooms_cnn (room_id) ON DELETE CASCADE ON UPDATE CASCADE;