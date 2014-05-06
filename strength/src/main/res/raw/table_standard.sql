
-- Table: standard
DROP TABLE IF EXISTS standard;
CREATE TABLE standard (
    _id            INTEGER PRIMARY KEY AUTOINCREMENT,
    fk_level_id    INTEGER NOT NULL,
    fk_exercise_id INTEGER NOT NULL,
    gender         TEXT    NOT NULL,
    bodyweight     REAL    NOT NULL,
    weight         REAL    NOT NULL,
    FOREIGN KEY ( fk_level_id ) REFERENCES level ( _id ),
    FOREIGN KEY ( fk_exercise_id ) REFERENCES exercise ( _id )
);

INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (1, 1, 1, 'm', 52.0, 42.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (2, 2, 1, 'm', 52.0, 82.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (3, 3, 1, 'm', 52.0, 92.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (4, 4, 1, 'm', 52.0, 135.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (5, 5, 1, 'm', 52.0, 175.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (6, 1, 1, 'm', 56.0, 47.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (7, 2, 1, 'm', 56.0, 87.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (8, 3, 1, 'm', 56.0, 100.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (9, 4, 1, 'm', 56.0, 145.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (10, 5, 1, 'm', 56.0, 187.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (11, 1, 1, 'm', 75.0, 62.5);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (12, 2, 1, 'm', 75.0, 115.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (13, 3, 1, 'm', 75.0, 135.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (14, 4, 1, 'm', 75.0, 185.0);
INSERT INTO [standard] ([_id], [fk_level_id], [fk_exercise_id], [gender], [bodyweight], [weight]) VALUES (15, 5, 1, 'm', 56.0, 235.0);