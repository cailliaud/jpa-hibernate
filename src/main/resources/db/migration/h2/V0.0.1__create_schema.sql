create sequence seq_referentiel_post start with 1 increment by 1;
create sequence seq_post start with 1 increment by 1;
create sequence seq_post_comment start with 1 increment by 1;
create sequence user_sequence start with 1 increment by 1;

create table referential_post
(
    code         varchar unique,
    category     varchar not null,
    sub_category varchar,
    primary key (code)

);

INSERT INTO referential_post (code, category, sub_category)
VALUES ('NEWS_H2', 'DATABASE', 'H2'),
       ('DEMO', 'CODE', null),
       ('TUTORIAL', 'INFRASTRUCTURE', 'DATABASE');


create table post
(
    id                    bigint  not null,
    title                 varchar(255),
    referential_post_code varchar not null,
    primary key (id),
    foreign key (referential_post_code) references referential_post (code)
);

create table post_comment
(
    id      bigint not null,
    post_id bigint not null,
    primary key (id),
    foreign key (post_id) references post (id)
);

create table user
(
    id       bigint       not null,
    email    varchar(100) not null unique,
    username varchar(100) not null,
    primary key (id)
);

