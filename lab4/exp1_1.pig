-- Load the file
data_entries = LOAD 'gaz_tracts_national.txt' USING PigStorage('\t') AS (state_code:chararray, tract_id:chararray, population:int, housing_units:int, land_area:long, water_area:int, land_area_sqmi:double, water_area_sqmi:double, latitude:double, longitude:double);

-- Combine data based on state and sum land area
state_aggregates = GROUP data_entries BY state_code;
land_totals = FOREACH state_aggregates GENERATE group AS state_group, SUM(data_entries.land_area) AS total_land_area;

-- Order by total land area, split, and output the top 10
ranked_states = ORDER land_totals BY total_land_area DESC;
top_states = LIMIT ranked_states 10;
STORE top_states INTO 'lab4_1_1/output';
