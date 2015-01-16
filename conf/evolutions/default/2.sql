
# --- !Ups

alter table currency_exchange_value drop constraint ck_currency_exchange_value_currency1;
alter table currency_exchange_value drop constraint ck_currency_exchange_value_currency2;
