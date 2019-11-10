create table if not exists users (
  id         serial not null primary key,
  first_name varchar(16) not null,
  last_name  varchar(16) not null,
  email      varchar(64) not null unique,
  created_on timestamp default CURRENT_TIMESTAMP not null,
  last_login timestamp
);
