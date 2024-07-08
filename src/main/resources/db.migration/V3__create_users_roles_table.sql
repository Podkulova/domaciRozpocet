CREATE TABLE users_roles (
                             user_id BIGINT,
                             role_id BIGINT,
                             PRIMARY KEY (user_id, role_id),
                             FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE
);


