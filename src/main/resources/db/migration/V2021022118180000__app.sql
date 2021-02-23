CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       login TEXT,
                       password TEXT,
                       active BOOLEAN NULL DEFAULT FALSE
);

CREATE TABLE chat_rooms (
                            id BIGSERIAL PRIMARY KEY,
                            title TEXT
);

CREATE TABLE chats (
                       id BIGSERIAL PRIMARY KEY,
                       users_id BIGSERIAL,
                       chatroom_id BIGSERIAL
);

CREATE INDEX chat_rooms_title_idx ON chat_rooms (title);
CREATE INDEX users_login_idx ON users (login);
CREATE INDEX users_active_idx ON users (active);