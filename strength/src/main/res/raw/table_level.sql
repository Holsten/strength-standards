
-- Table: level
DROP TABLE IF EXISTS level;
CREATE TABLE level (
    _id  INTEGER PRIMARY KEY,
    name TEXT    NOT NULL
                 UNIQUE
);

INSERT INTO [level] ([_id], [name]) VALUES (1, 'Untrained');
INSERT INTO [level] ([_id], [name]) VALUES (2, 'Novice');
INSERT INTO [level] ([_id], [name]) VALUES (3, 'Intermediate');
INSERT INTO [level] ([_id], [name]) VALUES (4, 'Advanced');
INSERT INTO [level] ([_id], [name]) VALUES (5, 'Elite');