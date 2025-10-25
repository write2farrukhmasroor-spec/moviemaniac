CREATE TABLE IF NOT EXISTS movie (
    id SERIAL PRIMARY KEY,
    movieName VARCHAR(100),
    movieDescription VARCHAR(1000),
    rating INTEGER
);
