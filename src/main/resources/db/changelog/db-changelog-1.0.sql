--liquibase formatted sql

--changeset acheron:1
create table if not exists public.users
(
    id                bigserial primary key,
    email             text      not null unique,
    password          text      not null,
    registration_date timestamp not null,
    first_name        text      not null,
    last_name         text      not null
);

--changeset acheron:2
create table if not exists public.note
(
    id          bigserial primary key,
    users_id    bigint references users (id),
    create_date timestamp not null,
    content     text
);