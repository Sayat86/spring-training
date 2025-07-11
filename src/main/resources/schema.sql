create table users
(
    id         bigserial primary key,
    name       varchar(100) not null,
    email      varchar(50)  not null unique,
    created_at timestamp    not null
);



create table channels
(
    id          bigserial primary key,
    name        varchar(255)  not null,
    description varchar(1000) not null,
    country     varchar(50)   not null,
    created_at  timestamp     not null,
    user_id     bigint        not null unique ,
    foreign key (user_id) references users (id)
);

create table videos
(
    id          bigserial primary key,
    name        varchar(255)  not null,
    description varchar(1000) not null,
    created_at  timestamp     not null,
    is_hidden   boolean       not null,
    views       int           not null,
    channel_id  bigint        not null,
    foreign key (channel_id) references channels (id)
);

create table subscriptions
(
    user_id    bigint references users (id),
    channel_id bigint references channels (id),
    primary key (user_id, channel_id)
);

create table views
(
    id         bigserial primary key,
    user_id    bigint references users (id),
    video_id   bigint references videos (id),
    created_at timestamp not null,
    updated_at timestamp not null
);
