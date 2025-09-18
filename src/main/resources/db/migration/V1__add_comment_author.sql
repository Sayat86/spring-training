ALTER TABLE comments
    ADD COLUMN user_id bigint;

UPDATE comments c
SET user_id = ch.user_id
FROM channels ch
WHERE c.channel_id = ch.id;

ALTER TABLE comments
    ALTER COLUMN user_id SET NOT NULL,
    ADD CONSTRAINT fk_comments_user
        FOREIGN KEY (user_id) REFERENCES users(id);