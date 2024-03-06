network_records = LOAD '/lab4_2/data/network_trace' USING PigStorage(' ') AS (event_time:chararray, net_IP:chararray, origin_ip:chararray, flow_direction:chararray, target_ip:chararray, data_protocol:chararray, info_data:chararray);

-- Filtering by TCP protocol
tcp_data_flow = FILTER network_records BY data_protocol == 'tcp';

-- Trimming the last segment of IP addresses
ip_relations = FOREACH tcp_data_flow GENERATE SUBSTRING(origin_ip, 0, LAST_INDEX_OF(origin_ip, '.')) AS mod_src_ip, SUBSTRING(target_ip, 0, LAST_INDEX_OF(target_ip, '.')) AS mod_dest_ip;

-- Removing duplicate entries
unique_relations = DISTINCT ip_relations;

-- Grouping by modified source IP and counting unique destination IPs
grouped_ips = GROUP unique_relations BY mod_src_ip;
count_destinations = FOREACH grouped_ips GENERATE group AS source_ip_group, COUNT(unique_relations) AS unique_dest_count;

-- Sorting by count in descending order and limiting to the top 10
ranked_sources = ORDER count_destinations BY unique_dest_count DESC;
top_ip_sources = LIMIT ranked_sources 10;

-- Storing the result in the specified directory
STORE top_ip_sources INTO '/lab4_2_1/exp2/output/';
