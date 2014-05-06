
-- Table: max
DROP TABLE IF EXISTS max;
CREATE TABLE max (
    _id            INTEGER PRIMARY KEY AUTOINCREMENT
                           NOT NULL,
    fk_exercise_id REAL    NOT NULL
                           REFERENCES exercise ( _id ),
    reps           INTEGER NOT NULL,
    weight         REAL    NOT NULL
);