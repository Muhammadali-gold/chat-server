create table auth_user
(
    id         bigint not null
        constraint auth_user_pkey
            primary key,
    attributes json,
    created_at timestamp,
    created_by bigint,
    state      integer,
    updated_at timestamp,
    updated_by bigint,
    password   varchar(255),
    username   varchar(255)
);

alter table auth_user
    owner to postgres;

create table chat
(
    id         bigint not null
        constraint chat_pkey
            primary key,
    attributes json,
    created_at timestamp,
    created_by bigint,
    state      integer,
    updated_at timestamp,
    updated_by bigint,
    name       varchar(255)
);

alter table chat
    owner to postgres;

create table message
(
    id         bigint not null
        constraint message_pkey
            primary key,
    attributes json,
    created_at timestamp,
    created_by bigint,
    state      integer,
    updated_at timestamp,
    updated_by bigint,
    text       text,
    chat_id    bigint not null
        constraint fkmejd0ykokrbuekwwgd5a5xt8a
            references chat,
    user_id    bigint not null
        constraint fkgtm0k57ywnwghjsso2fy497jr
            references auth_user
);

alter table message
    owner to postgres;

create table user_chat
(
    chat_id bigint not null
        constraint fklr24iyc3pugqj18ybujh6hqmj
            references chat,
    user_id bigint not null
        constraint fksokhjdqwk78lj5csdinhrx7s7
            references auth_user,
    constraint user_chat_pkey
        primary key (chat_id, user_id)
);

alter table user_chat
    owner to postgres;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;
