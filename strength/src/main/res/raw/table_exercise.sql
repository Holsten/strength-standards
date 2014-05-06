
-- Table: exercise
DROP TABLE IF EXISTS exercise;
CREATE TABLE exercise (
    _id  INTEGER PRIMARY KEY,
    name TEXT    NOT NULL
                 UNIQUE
);

INSERT INTO [exercise] ([_id], [name]) VALUES (1, 'Deadlift');
INSERT INTO [exercise] ([_id], [name]) VALUES (2, 'Squat');
INSERT INTO [exercise] ([_id], [name]) VALUES (3, 'Bench Press');
INSERT INTO [exercise] ([_id], [name]) VALUES (4, 'Power Clean');
INSERT INTO [exercise] ([_id], [name]) VALUES (5, 'Press');