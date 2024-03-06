-- Load the datasets
traffic_log = LOAD '/lab4_3/data/ip_trace' USING PigStorage(' ') AS (event_time:chararray, trace_id:long, origin_ip:chararray, separator:chararray, target_ip:chararray, comm_protocol:chararray, data_payload:chararray);
block_list = LOAD '/lab4_3/data/raw_block' USING PigStorage(' ') AS (entry_id:long, block_status:chararray);

-- Identify entries marked as blocked
flagged_entries = FILTER block_list BY block_status == 'Blocked';

-- Create an intersection of the two datasets based on IDs
matched_entries = JOIN traffic_log BY trace_id, flagged_entries BY entry_id;

-- Select relevant attributes for analysis
security_log = FOREACH matched_entries GENERATE event_time, traffic_log::trace_id AS trace_id, origin_ip, target_ip, block_status;

-- Store the intermediate results
STORE security_log INTO '/lab4_3/exp3_1/firewall' USING PigStorage(' ');

-- Group by source IP and count
ip_groups = GROUP security_log BY origin_ip;
activity_count = FOREACH ip_groups GENERATE group AS ip_group, COUNT(security_log) AS activity_total;

-- Apply a filter for the count condition
filtered_counts = FILTER activity_count BY (activity_total <= 6000);

-- Sort the records by activity count in descending order
sorted_activity = ORDER activity_count BY activity_total DESC;

-- Store the final sorted results
STORE sorted_activity INTO '/lab4_3/exp3_1/output' USING PigStorage('\t');
