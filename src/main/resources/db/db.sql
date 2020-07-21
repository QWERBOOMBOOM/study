create table book
(
    id           bigint auto_increment
        primary key,
    created_time datetime     not null,
    updated_time datetime     not null,
    author_id    bigint       not null,
    isbn         varchar(255) null,
    page_count   int          not null,
    title        varchar(50)  null
)

create table author
(
    id           bigint auto_increment
        primary key,
    created_time datetime    not null,
    updated_time datetime    not null,
    first_name   varchar(50) null,
    last_name    varchar(50) null
)
create table user
(
    id          bigint auto_increment
        primary key,
    name        varchar(64) default '' not null,
    password    varchar(64) default '' not null,
    salt        varchar(64) default '' not null,
    create_time datetime               null,
    update_time datetime               null,
    constraint user_name_uindex
        unique (name)
)
