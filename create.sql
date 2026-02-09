create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, account_id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, account_id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, account_id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table Account (id bigint not null, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;
create table Account_SEQ (next_val bigint) engine=InnoDB;
insert into Account_SEQ ( next_val ) values ( 1 );
create table Resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table Resume_SEQ (next_val bigint) engine=InnoDB;
insert into Resume_SEQ ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table WorkPosition (id bigint not null, company varchar(255), endDate varchar(255), startDate varchar(255), title varchar(255), bulletPoints json, primary key (id)) engine=InnoDB;
create table WorkPosition_SEQ (next_val bigint) engine=InnoDB;
insert into WorkPosition_SEQ ( next_val ) values ( 1 );
alter table Resume add constraint FK4ou1krfrx6ylth1h1110xohux foreign key (account_id) references Account (id);
alter table work_positions add constraint FK7iominr15ndo05qva2b2vklxh foreign key (work_id) references WorkPosition (id);
alter table work_positions add constraint FKeqoubxssa1ht69xic2cn9q8w8 foreign key (resume_id) references Resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, title varchar(255), account_id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, title varchar(255), account_id bigint not null, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);

    create table account (
        id bigint not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table account_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into account_seq ( next_val ) values ( 1 );

    create table resume (
        account_id bigint not null,
        id bigint not null,
        title varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table resume_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into resume_seq ( next_val ) values ( 1 );

    create table work_position_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into work_position_seq ( next_val ) values ( 1 );

    create table work_positions (
        resume_id bigint not null,
        work_id bigint not null,
        primary key (resume_id, work_id)
    ) engine=InnoDB;

    create table work_position (
        id bigint not null,
        company varchar(255),
        end_date varchar(255),
        start_date varchar(255),
        title varchar(255),
        bullet_points json,
        primary key (id)
    ) engine=InnoDB;

    alter table resume 
       add constraint FKajk5nplp9ujf1ow25wm0tfud8 
       foreign key (account_id) 
       references account (id);

    alter table work_positions 
       add constraint FKef290u6auukcf5d1fvigqc1lb 
       foreign key (work_id) 
       references work_position (id);

    alter table work_positions 
       add constraint FK91g87848uiq8fycf42xsbr4m8 
       foreign key (resume_id) 
       references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint not null, id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint, id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, title varchar(255), account_id bigint, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, title varchar(255), account_id bigint, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, label varchar(255), account_id bigint, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (id bigint not null, label varchar(255), account_id bigint, primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, bullet_points json, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint, id bigint not null, label varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
create table account (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table account_seq (next_val bigint) engine=InnoDB;
insert into account_seq ( next_val ) values ( 1 );
create table resume (account_id bigint, id bigint not null, label varchar(255), primary key (id)) engine=InnoDB;
create table resume_seq (next_val bigint) engine=InnoDB;
insert into resume_seq ( next_val ) values ( 1 );
create table work_position_seq (next_val bigint) engine=InnoDB;
insert into work_position_seq ( next_val ) values ( 1 );
create table work_positions (resume_id bigint not null, work_id bigint not null, primary key (resume_id, work_id)) engine=InnoDB;
create table work_position (id bigint not null, company varchar(255), end_date varchar(255), start_date varchar(255), title varchar(255), bullet_points json, primary key (id)) engine=InnoDB;
alter table resume add constraint FKajk5nplp9ujf1ow25wm0tfud8 foreign key (account_id) references account (id);
alter table work_positions add constraint FKef290u6auukcf5d1fvigqc1lb foreign key (work_id) references work_position (id);
alter table work_positions add constraint FK91g87848uiq8fycf42xsbr4m8 foreign key (resume_id) references resume (id);
