-- Add new 'genre' column (to store enum ordinal)
ALTER TABLE movie
ADD COLUMN genre INTEGER;

-- Add new 'cast' column to store list of actors/actress as JSON
ALTER TABLE movie
ADD COLUMN movieCast JSONB;

-- Optional: Add default values (if needed)
 UPDATE movie SET genre = 0 WHERE genre IS NULL;
 UPDATE movie SET movieCast = '{"actors": [], "actress": []}'::jsonb WHERE movieCast IS NULL;
