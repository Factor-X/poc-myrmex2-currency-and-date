# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table currency_exchange_value (
  id                        bigint not null,
  currency1                 int not null,
  currency2                 int not null,
  period_id                 bigint not null,
  value                     float not null,
  constraint ck_currency_exchange_value_currency1 check (currency1 in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149)),
  constraint ck_currency_exchange_value_currency2 check (currency2 in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149)),
  constraint pk_currency_exchange_value primary key (id))
;

create table period (
  dtype                     varchar(10) not null,
  id                        bigint not null,
  code                      varchar(255) not null,
  nb_day                    integer not null,
  start_date                timestamp not null,
  end_date                  timestamp not null,
  previous_year_id          bigint,
  period_year_id            bigint,
  period_quarter_id         bigint,
  previous_month_id         bigint,
  previous_quarter_id       bigint,
  constraint pk_period primary key (id))
;

create sequence currency_exchange_value_seq;

create sequence period_seq;

alter table currency_exchange_value add constraint fk_currency_exchange_value_per_1 foreign key (period_id) references period (id);
create index ix_currency_exchange_value_per_1 on currency_exchange_value (period_id);
alter table period add constraint fk_period_previousYear_2 foreign key (previous_year_id) references period (id);
create index ix_period_previousYear_2 on period (previous_year_id);
alter table period add constraint fk_period_periodYear_3 foreign key (period_year_id) references period (id);
create index ix_period_periodYear_3 on period (period_year_id);
alter table period add constraint fk_period_periodQuarter_4 foreign key (period_quarter_id) references period (id);
create index ix_period_periodQuarter_4 on period (period_quarter_id);
alter table period add constraint fk_period_previousMonth_5 foreign key (previous_month_id) references period (id);
create index ix_period_previousMonth_5 on period (previous_month_id);
alter table period add constraint fk_period_periodYear_6 foreign key (period_year_id) references period (id);
create index ix_period_periodYear_6 on period (period_year_id);
alter table period add constraint fk_period_previousQuarter_7 foreign key (previous_quarter_id) references period (id);
create index ix_period_previousQuarter_7 on period (previous_quarter_id);



# --- !Downs

drop table if exists currency_exchange_value cascade;

drop table if exists period cascade;

drop sequence if exists currency_exchange_value_seq;

drop sequence if exists period_seq;

