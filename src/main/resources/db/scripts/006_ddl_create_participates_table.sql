CREATE TABLE participates (
      id serial PRIMARY KEY,
      thing_id int not null REFERENCES things(id),
      user_id int not null REFERENCES j_user(id),
      UNIQUE (thing_id, user_id)
);